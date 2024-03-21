package com.android.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val reg_name_text = findViewById<EditText>(R.id.reg_name_read)
        val reg_id_text = findViewById<EditText>(R.id.reg_id_read)
        val reg_password_text = findViewById<EditText>(R.id.reg_password_read)
        val reg_button_finish = findViewById<Button>(R.id.register_button_finish)

        reg_button_finish.setOnClickListener {
            if(reg_name_text.text.isEmpty() || reg_id_text.text.isEmpty() || reg_password_text.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "회원가입 성공", Toast.LENGTH_LONG).show()

            val reg_id:String = reg_id_text.text.toString()
            val reg_password:String = reg_password_text.text.toString()

            intent.putExtra("id", reg_id)
            intent.putExtra("passWord", reg_password)
            setResult(RESULT_OK, intent)

            finish()
        }
    }

}