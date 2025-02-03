import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

@Composable
fun FaceDetectionScreen(navController: NavController) {
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let { imageBitmap = it }
    }

    Column(modifier = Modifier.fillMaxSize().
    padding(32.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        imageBitmap?.let { bitmap ->
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Captured Face", modifier = Modifier.fillMaxSize())
            FaceDetectionProcess(bitmap)
        }

        Button(onClick = { launcher.launch() },) {
            Text(text = "Capture Face")
        }
    }
}

@Composable
fun FaceDetectionProcess(bitmap: Bitmap) {
    val image = InputImage.fromBitmap(bitmap, 90)
    val detectorOptions = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
        .build()

    val detector = FaceDetection.getClient(detectorOptions)

    detector.process(image)
        .addOnSuccessListener { faces ->
            if (faces.isNotEmpty()) {
                println("Face Detected!") // Replace with logic to store or recognize face
            } else {
                println("No Face Detected!")
            }
        }
        .addOnFailureListener {
            println("Error detecting face!")
        }
}

@Composable
@Preview(showBackground = true)
fun FaceDetectionScreenPreview() {
    FaceDetectionScreen(navController = NavController(LocalContext.current))

}

