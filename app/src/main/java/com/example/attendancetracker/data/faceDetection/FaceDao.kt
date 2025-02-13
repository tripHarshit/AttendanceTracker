package com.example.attendancetracker.data.faceDetection

import androidx.room.*

@Dao
interface FaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFace(face: FaceEntity)

    @Query("SELECT * FROM face_data")
    suspend fun getAllFaces(): List<FaceEntity>

    @Query("SELECT * FROM face_data WHERE regNumber= :regNumber LIMIT 1")
    suspend fun getFaceByName(regNumber: String): FaceEntity?

    @Delete
    suspend fun deleteFace(face: FaceEntity)
}
