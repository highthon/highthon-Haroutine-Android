package com.example.haroutine_android.ui.hyunmyeong.routinedetail

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityRoutineDetailBinding
import com.example.haroutine_android.ui.BaseActivity
import com.example.haroutine_android.util.repeatOnStarted
import com.google.android.gms.tagmanager.Container
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class RoutineDetailActivity : BaseActivity<ActivityRoutineDetailBinding>(
    R.layout.activity_routine_detail
) {
    private val remoteDetailViewModel: RemoteDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bt.setOnClickListener {
            showShortToast("수험생 열공 루틴 시작!")
            finish()
        }

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

    private fun handleEvent(event: RemoteDetailViewModel.Event) {
        when (event) {
            is RemoteDetailViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is RemoteDetailViewModel.Event.FetchDetailSuccess -> {
                event.routineDetailResponse
            }
        }
    }


    override fun initView() {
    }
}