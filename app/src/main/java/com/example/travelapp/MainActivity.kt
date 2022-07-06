package com.example.travelapp

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        setUpListeners()
    }

    private fun setUpListeners(){
        btnClose.setOnClickListener {
            this.finish()
        }

        btnCreateNewAcc.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }
    }
}