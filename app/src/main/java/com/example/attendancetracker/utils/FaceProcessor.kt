package com.example.attendanceapp.utils

import android.content.Context
import android.util.Log
import org.opencv.core.*
import org.opencv.dnn.Dnn
import org.opencv.dnn.Net
import org.opencv.imgproc.Imgproc
import org.opencv.objdetect.CascadeClassifier
import java.io.File
import java.io.FileOutputStream
import kotlin.math.sqrt

class FaceProcessor(private val context: Context) {

    private var faceCascade: CascadeClassifier? = null
    private var model: Net? = null

    init {
        loadCascade()
        loadModel()
    }

    // Load Haar Cascade for face detection
    private fun loadCascade() {
        try {
            val inputStream = context.assets.open("haarcascade_frontalface_default.xml")
            val cascadeFile = File(context.cacheDir, "haarcascade_frontalface_default.xml")

            val outputStream = FileOutputStream(cascadeFile)
            inputStream.copyTo(outputStream)
            inputStream.close()
            outputStream.close()

            faceCascade = CascadeClassifier(cascadeFile.absolutePath)
        } catch (e: Exception) {
            Log.e("FaceProcessor", "Error loading cascade", e)
        }
    }

    // Load pre-trained DNN model
    private fun loadModel() {
        val modelPath = context.filesDir.absolutePath + "/face_model.pb"
        model = Dnn.readNetFromTensorflow(modelPath)
    }

    // Detect face in the given frame
    fun detectFace(frame: Mat): Rect? {
        val faces = MatOfRect()
        faceCascade?.detectMultiScale(frame, faces, 1.1, 4)
        return faces.toArray().firstOrNull()
    }

    // Extract face embeddings using DNN model
    fun extractEmbeddings(face: Mat): FloatArray {
        val blob = Dnn.blobFromImage(face, 1.0, Size(96.0, 96.0), Scalar(104.0, 177.0, 123.0))
        model?.setInput(blob)

        val output = model?.forward() ?: return FloatArray(128) // Ensure output is not null

        // Check output shape
        println("Model output shape: ${output.size()}")

        // Convert Mat to FloatArray safely
        val floatArray = FloatArray(128)
        output.get(0, 0, floatArray) // Correct way to extract values
        return floatArray
    }


    // Convert embeddings to string
    fun embeddingsToString(embeddings: FloatArray): String {
        return embeddings.joinToString(",")
    }
}