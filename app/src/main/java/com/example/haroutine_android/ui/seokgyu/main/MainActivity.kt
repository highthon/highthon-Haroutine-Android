package com.example.haroutine_android.ui.seokgyu.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.NotificationCompat
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityMainBinding
import com.example.haroutine_android.ui.BaseActivity
import com.example.haroutine_android.ui.hyunmyeong.MyPageActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.NonRoutineDetailActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.RoutineDetailActivity

import com.example.haroutine_android.ui.seokgyu.postcreate.RoutinePostActivity

import com.example.haroutine_android.ui.notification.NotificationService


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var routineAdapter: RoutineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.routine.setOnClickListener {
            val intent = Intent(this, RoutineDetailActivity::class.java)
            startActivity(intent)
        }
        binding.nonroutine.setOnClickListener {
            val intent = Intent(this, NonRoutineDetailActivity::class.java)
            startActivity(intent)
        }
        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, RoutinePostActivity::class.java))

            val intent = Intent(this@MainActivity, NotificationService::class.java)
            intent.action = NotificationService.ACTIVITY_SERVICE

            if (Build.VERSION.SDK_INT >= 26) {
                val CHANNEL_ID = "my_channel_01"
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
                    channel
                )
                startService(intent)

            }
        }
    }

    private fun handleEvent(event: MainViewModel.Event) {
        when(event) {
            is MainViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is MainViewModel.Event.GetRoutineSuccess -> {
            }
        }
    }

    override fun initView() {
    }
}