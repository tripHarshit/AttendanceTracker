package com.example.attendanceapp.repository

import com.example.attendancetracker.data.FaceDao
import com.example.attendancetracker.data.FaceEntity


class FaceRepository(private val dao: FaceDao) {
    suspend fun saveFace(studentId: String, faceEmbedding: String) {
        val face = FaceEntity(studentId = studentId, faceEncoding = faceEmbedding)
        dao.insertFace(face)
    }

    suspend fun getAllFaces(): List<FaceEntity> {
        return dao.getAllFaces()
    }
}