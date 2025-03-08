package com.example.attendanceapp.camera

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import org.opencv.android.CameraBridgeViewBase
import org.opencv.core.Mat

class CameraPreview(context: Context) : SurfaceView(context), SurfaceHolder.Callback {
    override fun surfaceCreated(holder: SurfaceHolder) {}
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
    override fun surfaceDestroyed(holder: SurfaceHolder) {}
}