package com.example.haroutine_android.ui.hyunmyeong.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.haroutine_android.MainActivity
import com.example.haroutine_android.R
import com.example.haroutine_android.ui.hyunmyeong.HomeActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.NonRoutineDetailActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.RoutineDetailActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Splash(this)
        }
    }
}

@Composable
fun Splash(
    context: Context
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.background),
            contentDescription = ""
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(170.dp),
            painter = painterResource(R.drawable.logo2),
            contentDescription = ""
        )
    }
    startMainActivity(context)
}

fun startMainActivity(context: Context) {
    Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    },700)

}