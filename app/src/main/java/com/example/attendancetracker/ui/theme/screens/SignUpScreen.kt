package com.example.attendancetracker.ui.theme.screens

import android.graphics.Outline
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attendancetracker.ui.theme.navigation.CommonAppScreens
import com.example.attendancetracker.ui.theme.navigation.FacultyScreens
import com.example.attendancetracker.ui.theme.navigation.StudentScreens

@Composable
fun SignUpScreen(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var regNo by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("Student") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome Aboard!", style = MaterialTheme.typography.headlineMedium,
            fontWeight  = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email")},
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),)

        //EXTRA STUDENT SPECIFIC FIELD ADDED

        if(role == "Student") {
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = regNo, onValueChange = { regNo = it }, label = { Text("Reg No.") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( start = 16.dp, end = 16.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Role Selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Using As A?",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp))
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected = role == "Student",
                onClick = { role = "Student" }
            )
            Text("Student")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = role == "Faculty",
                onClick = { role = "Faculty" }
            )
            Text("Faculty")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (role == "Student") {
                navController.navigate(StudentScreens.HomeScreen.name)
            } else if (role == "Faculty") {
                navController.navigate(FacultyScreens.HomeScreen.name)
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp),
            shape = RoundedCornerShape(12.dp)) {
            Text(text = "Sign Up",
                modifier = Modifier.padding(vertical = 6.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate(CommonAppScreens.LoginScreen.name ) }) {
            Text(text = "Already have an account? Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpScreen(rememberNavController())
}