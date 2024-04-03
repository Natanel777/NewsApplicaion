package natanel.android.newsapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import natanel.android.newsapplication.ui.screens.HomeScreen

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen.routh){

        composable(Routes.HomeScreen.routh){
            HomeScreen()
        }
    }

}