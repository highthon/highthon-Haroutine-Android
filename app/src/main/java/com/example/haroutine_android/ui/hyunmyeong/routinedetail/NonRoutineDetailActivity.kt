package com.example.haroutine_android.ui.hyunmyeong.routinedetail

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.FileProvider
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityNonRoutineDetailBinding
import com.example.haroutine_android.ui.BaseActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class NonRoutineDetailActivity : BaseActivity<ActivityNonRoutineDetailBinding>(
    R.layout.activity_non_routine_detail
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.share.setOnClickListener {
            val view: View = window.decorView.rootView
            view.isDrawingCacheEnabled = true //화면에 뿌릴때 캐시 사용

            //캐시 -> 비트맵 변환
            val screenBitmap: Bitmap = Bitmap.createBitmap(view.drawingCache)
            try {
                val cachePath = File(applicationContext.cacheDir, "images")
                cachePath.mkdirs() // don't forget to make the directory
                val stream =
                    FileOutputStream(cachePath.toString() + "/image.png") // overwrites this image every time
                screenBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.close()
                val newFile = File(cachePath, "image.png")
                val contentUri: Uri = FileProvider.getUriForFile(
                    applicationContext,
                    "com.example.haroutine_android", newFile
                )
                val Sharing_intent = Intent(Intent.ACTION_SEND)
                Sharing_intent.type = "image/png"
                Sharing_intent.putExtra(Intent.EXTRA_STREAM, contentUri)
                startActivity(Intent.createChooser(Sharing_intent, "Share image"))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun initView() {

    }
}