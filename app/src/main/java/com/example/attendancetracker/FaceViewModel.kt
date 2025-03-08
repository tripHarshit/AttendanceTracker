package com.example.attendanceapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.attendacetracker.data.FaceDatabase
import com.example.attendanceapp.repository.FaceRepository
import com.example.attendanceapp.utils.FaceProcessor
import kotlinx.coroutines.launch
import org.opencv.core.Mat

class FaceViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = FaceDatabase.getDatabase(application).faceDao()
    private val repository = FaceRepository(dao)
    private val processor = FaceProcessor(application)

    fun saveFace(studentId: String, faceMat: Mat) {
        viewModelScope.launch {
            val embeddings = processor.extractEmbeddings(faceMat)
            repository.saveFace(studentId, processor.embeddingsToString(embeddings))
        }
    }
}