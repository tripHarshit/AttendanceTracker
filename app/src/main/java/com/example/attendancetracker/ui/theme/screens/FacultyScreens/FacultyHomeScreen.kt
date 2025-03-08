package com.example.attendancetracker.ui.theme.screens.FacultyScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.attendancetracker.R
import com.example.attendancetracker.ui.theme.navigation.FacultyScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacultyHomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Faculty Dashboard", fontSize = 20.sp) })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(FacultyScreens.SelectionScreen.name) },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(painterResource(id = R.drawable.baseline_camera_alt_24), contentDescription = "Take Attendance")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            FacultyHomeCard(title = "View Attendance", icon = R.drawable.baseline_table_view_24) {
                navController.navigate("viewAttendance")
            }

            FacultyHomeCard(title = "Manage Classes", icon = R.drawable.baseline_class_24) {
                navController.navigate("manageClasses")
            }

            FacultyHomeCard(title = "Profile & Settings", icon = R.drawable.baseline_person_2_24) {
                navController.navigate("profile")
            }
        }
    }
}

@Composable
fun FacultyHomeCard(title: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = title, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontSize = 18.sp)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FacultyHomeScreenPreview() {
    FacultyHomeScreen(navController = NavController(LocalContext.current))

}