package com.example.haroutine_android.ui.hyunmyeong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityHomeBinding
import com.example.haroutine_android.ui.BaseActivity
import com.example.haroutine_android.ui.hyunmyeong.routinedetail.RemoteDetailViewModel
import com.example.haroutine_android.ui.seokgyu.main.MainActivity
import com.example.haroutine_android.util.repeatOnStarted

class HomeActivity : BaseActivity<ActivityHomeBinding>(
    R.layout.activity_home
) {

    val vm: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bt.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        repeatOnStarted {
            //vm.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: RegisterViewModel.Event) {
        when(event) {
            is RegisterViewModel.Event.ErrorMessage -> {
                showShortToast(event.message)
            }
            is RegisterViewModel.Event.Success -> {
            }
        }
    }

    override fun initView() {
    }
}