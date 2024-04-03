package natanel.android.newsapplication.ui.navigation

sealed class Routes(val routh: String) {

    data object HomeScreen:Routes("home_screen")
}