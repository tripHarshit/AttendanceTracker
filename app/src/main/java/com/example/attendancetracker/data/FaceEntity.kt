package com.example.attendancetracker.data
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "face_table")
data class FaceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val studentId: String,
    val faceEncoding: String ,// Store face embeddings as a string (JSON or Base64)
    val timestamp: Long = System.currentTimeMillis()
)
