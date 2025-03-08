package com.example.attendancetracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.attendancetracker.data.FaceEntity


@Dao
interface FaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFace(face: FaceEntity)

    @Query("SELECT * FROM face_table WHERE studentId = :studentId")
    suspend fun getFaceByStudentId(studentId: String): FaceEntity?

    @Query("SELECT * FROM face_table")
    suspend fun getAllFaces(): List<FaceEntity>

    @Delete
    suspend fun deleteFace(face: FaceEntity)
}