package com.deepthought.gogi.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deepghought.core.theme.GogiTheme
import com.deepthought.home.HomePage
import com.deepthought.inputname.InputNamePage
import com.deepthought.notification.NotificationPage
import com.deepthought.splash.SplashPage
import org.koin.androidx.compose.getViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GogiTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "splash",
                ) {
                    composable("splash") {
                        SplashPage(viewModel = getViewModel(), navController = navController)
                    }

                    composable("inputName") {
                        InputNamePage(viewModel = getViewModel(), navController = navController)
                    }

                    composable("home") {
                        HomePage(viewModel = getViewModel(), navController = navController)
                    }

                    composable("notification") {
                        NotificationPage(viewModel = getViewModel(), navController = navController)
                    }
                }
            }
        }
    }
}
