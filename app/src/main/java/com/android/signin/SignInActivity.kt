package com.android.signin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val id_text = findViewById<EditText>(R.id.id_read)
        val password_text = findViewById<EditText>(R.id.password_read)
        val signin_button = findViewById<Button>(R.id.signin_button)
        val register_button = findViewById<Button>(R.id.register_button)

        signin_button.setOnClickListener {
            if(id_text.text.isEmpty()) {
                Toast.makeText(this, "아이디를 확인해주세요",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(id_text.text.toString().length < 8) {
                Toast.makeText(this, "아이디는 8자 이상이여야 합니다", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(password_text.text.isEmpty()) {
                Toast.makeText(this, "비밀번호를 확인해주세요",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(password_text.text.toString().length < 8) {
                Toast.makeText(this, "비밀번호는 8자 이상이여야 합니다", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "로그인 성공",Toast.LENGTH_LONG).show()

            val id:String = id_text.text.toString()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }

        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val id = result.data?.getStringExtra("id")
                val password = result.data?.getStringExtra("passWord")
                id_text.setText(id)
                password_text.setText(password)
            }
        }


        register_button.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            launcher.launch(intent)
        }
    }
}