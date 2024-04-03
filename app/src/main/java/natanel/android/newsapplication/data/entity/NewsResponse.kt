package natanel.android.newsapplication.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
): Parcelable