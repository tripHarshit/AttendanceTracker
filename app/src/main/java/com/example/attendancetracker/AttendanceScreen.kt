import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.attendanceapp.viewmodel.FaceViewModel

@Composable
fun AttendanceScreen(viewModel: FaceViewModel) {
    Button(onClick = { /* Capture and save face */ }) {
        Text("Capture Face")
    }
}