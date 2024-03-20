package com.android.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idText = findViewById<EditText>(R.id.idread)
        val passWordText = findViewById<EditText>(R.id.passwordread)
        val signInButton = findViewById<Button>(R.id.signinbutton)
        val registerButton = findViewById<Button>(R.id.registerbutton)

        signInButton.setOnClickListener {
            if(idText.text.isEmpty()) {
                Toast.makeText(this, "아이디를 확인해주세요",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(passWordText.text.isEmpty()) {
                Toast.makeText(this, "비밀번호를 확인해주세요",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "로그인 성공",Toast.LENGTH_LONG).show()

            val id:String = idText.text.toString()
            val passWord:String = passWordText.text.toString()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("passWord", passWord)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}