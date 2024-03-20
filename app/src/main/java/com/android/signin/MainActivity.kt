package com.android.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id_text = findViewById<EditText>(R.id.id_read)
        val password_text = findViewById<EditText>(R.id.password_read)
        val signin_button = findViewById<Button>(R.id.signin_button)
        val register_button = findViewById<Button>(R.id.register_button)

        signin_button.setOnClickListener {
            if(id_text.text.isEmpty()) {
                Toast.makeText(this, "아이디를 확인해주세요",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(password_text.text.isEmpty()) {
                Toast.makeText(this, "비밀번호를 확인해주세요",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "로그인 성공",Toast.LENGTH_LONG).show()

            val id:String = id_text.text.toString()
            val passWord:String = password_text.text.toString()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("passWord", passWord)
            startActivity(intent)
        }

        register_button.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}