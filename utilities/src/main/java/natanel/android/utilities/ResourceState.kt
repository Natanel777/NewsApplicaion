package natanel.android.utilities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


sealed class ResourceState<T> {
    @Parcelize
    class Loading<T> : ResourceState<T>(), Parcelable

    @Parcelize
    data class Success<T> (val data: @RawValue T): ResourceState<T>(), Parcelable

    @Parcelize
    data class Error<T> (val errorMessage: String): ResourceState<T>(), Parcelable

}