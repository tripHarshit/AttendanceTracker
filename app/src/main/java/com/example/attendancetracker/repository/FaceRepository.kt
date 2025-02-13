package com.example.attendancetracker.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.attendancetracker.data.faceDetection.FaceDao
import com.example.attendancetracker.data.faceDetection.FaceEntity
import com.google.gson.Gson

class FaceRepository(private val faceDao: FaceDao) {

    // Insert face into database
    suspend fun insertFace(name: String, embedding: FloatArray) {
        val jsonEmbedding = convertEmbeddingToJson(embedding)
        val face = FaceEntity(name = name, embedding = jsonEmbedding)

        withContext(Dispatchers.IO) {
            faceDao.insertFace(face)
        }
    }

    // Get all stored faces
    suspend fun getAllFaces(): List<FaceEntity> {
        return withContext(Dispatchers.IO) {
            faceDao.getAllFaces()
        }
    }

    // Get face by name
    suspend fun getFaceByName(name: String): FloatArray? {
        val face = withContext(Dispatchers.IO) {
            faceDao.getFaceByName(name)
        }
        return face?.embedding?.let { convertJsonToEmbedding(it) }
    }
}
fun convertEmbeddingToJson(embedding: FloatArray): String {
    return Gson().toJson(embedding)
}

// Convert JSON back to FloatArray for comparison
fun convertJsonToEmbedding(json: String): FloatArray {
    return Gson().fromJson(json, FloatArray::class.java)
}
