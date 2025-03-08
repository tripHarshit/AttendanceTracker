package com.example.attendancetracker.ui.theme.screens.FacultyScreens

import android.view.RoundedCorner
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attendancetracker.data.DropDownOptions
import com.example.attendancetracker.ui.theme.navigation.CommonAppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionScreen(navController: NavController,
                    batchList: List<String>,
                    branchList: List<String>,
                    courseList: List<String>
) {
    var branchSelected by remember { mutableStateOf("") }
    var batchSelected by remember { mutableStateOf("") }
    var courseSelected by remember { mutableStateOf("") }

    var branchExpanded by remember { mutableStateOf(false) }
    var batchExpanded by remember { mutableStateOf(false) }
    var courseExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 64.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        // Branch Dropdown
        Text(text = "Choose Branch:", style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(10.dp))

        ExposedDropdownMenuBox(
            expanded = branchExpanded,
            onExpandedChange = { branchExpanded = !branchExpanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = branchSelected,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = branchExpanded)
                }
            )

            ExposedDropdownMenu(
                expanded = branchExpanded,
                onDismissRequest = { branchExpanded = false }
            ) {
                branchList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            branchSelected = option
                            branchExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Batch Dropdown
        Text(text = "Choose Batch:", style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(10.dp))

        ExposedDropdownMenuBox(
            expanded = batchExpanded,
            onExpandedChange = { batchExpanded = !batchExpanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = batchSelected,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = batchExpanded)
                }
            )

            ExposedDropdownMenu(
                expanded = batchExpanded,
                onDismissRequest = { batchExpanded = false }
            ) {
                batchList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            batchSelected = option
                            batchExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Course Dropdown
        Text(text = "Choose Course:", style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(10.dp))

        ExposedDropdownMenuBox(
            expanded = courseExpanded,
            onExpandedChange = { courseExpanded = !courseExpanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = courseSelected,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = courseExpanded)
                }
            )

            ExposedDropdownMenu(
                expanded = courseExpanded,
                onDismissRequest = { courseExpanded = false }
            ) {
                courseList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            courseSelected = option
                            courseExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display Selected Items
        Text(text = "Selected Branch: $branchSelected", style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
            fontWeight = FontWeight.SemiBold)
        Text(text = "Selected Batch: $batchSelected", style = MaterialTheme.typography.bodyMedium,

            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
            fontWeight = FontWeight.SemiBold)
        Text(text = "Selected Course: $courseSelected", style = MaterialTheme.typography.bodyMedium,

            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
            fontWeight = FontWeight.SemiBold)

        //  BOTTOM BUTTON
        Spacer(modifier =Modifier.height(64.dp))
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()) {

            Button(onClick ={navController.navigate(route = CommonAppScreens.FaceDetectionScreen.name)},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)) {
                Text(text = "Capture",
                    modifier = Modifier.padding(top = 6.dp, bottom = 6.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDropdownMenuScreen() {
    SelectionScreen(rememberNavController(),
        DropDownOptions.batch, DropDownOptions.branch, DropDownOptions.course,)
}