package com.android.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("id")
        val passWord = intent.getStringExtra("passWord")

        val tv_home_id = findViewById<TextView>(R.id.home_id)
        tv_home_id.setText(id)

        val home_button = findViewById<Button>(R.id.home_button_finish)

        home_button.setOnClickListener {
            finish()
        }
    }
}

//내일 할 일: import android.widget.*** 활용해서 homeActivity 디자인하기