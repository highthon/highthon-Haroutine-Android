package com.example.haroutine_android.ui.seokgyu.postcreate

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ActivityPostCreateBinding
import com.example.haroutine_android.ui.BaseActivity

class RoutinePostActivity : BaseActivity<ActivityPostCreateBinding>(R.layout.activity_post_create) {
    private lateinit var tagAdapter: TagAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.etTag.setOnKeyListener { view, keyCode, keyEvent ->
            if ((keyEvent.action == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.tag.visibility = View.VISIBLE
                binding.etTag.setText("")
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
        binding.btnCommon.setOnClickListener {
            it.setBackgroundResource(R.drawable.selected_button)
        }

        binding.btnNext.setOnClickListener { finish() }
    }

    override fun initView() {

    }
}