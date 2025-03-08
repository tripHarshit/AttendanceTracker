package com.example.attendancetracker.ui.theme.navigation

import com.example.attendancetracker.ui.theme.screens.FacultyScreens.CameraScreen
import SplashScreen
import StudentHomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attendancetracker.data.DropDownOptions
import com.example.attendancetracker.ui.theme.screens.FacultyScreens.FacultyHomeScreen
import com.example.attendancetracker.ui.theme.screens.FacultyScreens.SelectionScreen
import com.example.attendancetracker.ui.theme.screens.LoginScreen
import com.example.attendancetracker.ui.theme.screens.SignUpScreen

enum class CommonAppScreens {
    BaseScreen,
    LoginScreen,
    SignUpScreen,
    FaceDetectionScreen,
    ProfileScreen,
    SettingsScreen
}

enum class StudentScreens {
    HomeScreen
}

enum class FacultyScreens {
    HomeScreen,
    SelectionScreen
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = FacultyScreens.SelectionScreen.name) {
        composable(route = CommonAppScreens.BaseScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(route = CommonAppScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(route = CommonAppScreens.SignUpScreen.name) {
            SignUpScreen(navController = navController)
        }
        composable(route = StudentScreens.HomeScreen.name) {
            StudentHomeScreen()
        }
        composable(route = FacultyScreens.HomeScreen.name) {
            FacultyHomeScreen(navController = navController)
        }
        composable(route = CommonAppScreens.FaceDetectionScreen.name){
            CameraScreen(onFaceCaptured = { /* Handle face capture here */ })
        }
        composable(route = FacultyScreens.SelectionScreen.name) {
            SelectionScreen(navController, DropDownOptions.batch, DropDownOptions.branch, DropDownOptions.course)
        }
    }
}
