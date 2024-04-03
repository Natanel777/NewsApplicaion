package natanel.android.newsapplication.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import natanel.android.newsapplication.data.AppConstants
import natanel.android.newsapplication.data.api.ApiService
import natanel.android.newsapplication.data.datasource.NewsDataSource
import natanel.android.newsapplication.data.datasource.NewsDataSourceImpl
import natanel.android.newsapplication.ui.repository.NewsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module // Marked as Dagger module
@InstallIn(SingletonComponent::class) // for dependency injection in singleton scope
class AppMoudle {

    @Provides //tell Dagger how to create instances in this @Module
    @Singleton
    //Build the api call
    fun providesRetrofit () : Retrofit {

        //in order to see Json in the logcat
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        //An interceptor added to the client (we can modify the response here if we wish to)
        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }

        //Timeout for the client to read the http request if no response throw error
        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }

        //used to build JSON adapters for serialization and deserialization
        //like Gson but faster and supports Kotlin-specific features like sealed classes and Kotlin-specific annotations
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder()
            .baseUrl(AppConstants.APP_BASE_URL) // https://newsapi.org/
            .client(httpClient.build()) // client / logs
            .addConverterFactory(MoshiConverterFactory.create(moshi)) //json convertor
            .build()
    }

    @Provides
    @Singleton
    //Creates the api call
    fun providesApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    //return the JSON Data source
    fun providesNewDataSource(apiService: ApiService) : NewsDataSource{
        return NewsDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesNewsViewModel(newsDataSource: NewsDataSource): NewsRepository{

        return NewsRepository(newsDataSource)
    }



}