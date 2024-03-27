package com.android.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("id")
        val passWord = intent.getStringExtra("passWord")

        val tv_home_id = findViewById<TextView>(R.id.home_id)
        tv_home_id.setText("${id} 님 환영합니다!")

        val home_button = findViewById<Button>(R.id.home_button_finish)

        home_button.setOnClickListener {
            finish()
        }

        val homeImage = findViewById<ImageView>(R.id.home_image)
        val imageRes = intArrayOf(
            R.drawable.man1,
            R.drawable.man2,
            R.drawable.man3,
            R.drawable.man4,
            R.drawable.man5
        )

        val random = imageRes.indices.random()
        val randomRes = imageRes[random]
        homeImage.setImageResource(randomRes)
    }
}