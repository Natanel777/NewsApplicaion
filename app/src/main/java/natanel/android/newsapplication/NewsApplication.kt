package natanel.android.newsapplication

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // help us inject every class in this app and attach it with their @Provides
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Coming_inside_onCreate")
    }

    companion object{
        const val TAG = "NewsApplication"
    }
}