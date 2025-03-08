import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*
import com.example.attendancetracker.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentHomeScreen(studentName: String = "Harshit") {
    val subjects = listOf(
        SubjectAttendance("Mathematics", 85),
        SubjectAttendance("Physics", 78),
        SubjectAttendance("Computer Science", 92),
        SubjectAttendance("English", 88)
    )

    Scaffold(
        topBar = { StudentTopBar(studentName) },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF5F5F5))
        ) {
            Text(
                text = "Today's Attendance",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                items(subjects) { subject ->
                    SubjectAttendanceCard(subject)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentTopBar(studentName: String) {
    TopAppBar(
        title = {
            Column {
                Text(text = "Welcome, $studentName!", fontWeight = FontWeight.Bold)
                Text(text = getCurrentDate(), fontSize = 12.sp, color = Color.Gray)
            }
        }
    )
}

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("EEE, dd MMM yyyy")
    return sdf.format(Date())
}

@Composable
fun SubjectAttendanceCard(subject: SubjectAttendance) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = subject.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "Attendance: ${subject.attendance}%", fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

data class SubjectAttendance(val name: String, val attendance: Int)

@Preview(showBackground = true)
@Composable
fun PreviewStudentHomeScreen() {
    StudentHomeScreen()
}