package com.hanakusoman.hola

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_launch)

        demo_button.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}
