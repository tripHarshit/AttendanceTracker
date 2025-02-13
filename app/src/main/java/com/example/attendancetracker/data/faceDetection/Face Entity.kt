package com.example.attendancetracker.data.faceDetection
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "face_data")
data class FaceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,  // Name of the person
    val embedding: String, // Store face embedding as a JSON string
    val timestamp: Long = System.currentTimeMillis()
)