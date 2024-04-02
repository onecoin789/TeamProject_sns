package com.example.teamproject_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.Serializable

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val name = findViewById<EditText>(R.id.et_naming)
        val id2 = findViewById<EditText>(R.id.et_id2)
        val password2 = findViewById<EditText>(R.id.et_password2)
        val confirmpassword = findViewById<EditText>(R.id.confirmpw)
        val btn_sign = findViewById<Button>(R.id.btn_signup2)






        btn_sign.setOnClickListener {
            if (name.text.toString().isNotEmpty() && id2.text.toString().isNotEmpty()
                && password2.text.toString().isNotEmpty() && confirmpassword.text.toString().isNotEmpty()) {
                if (password2.text.toString() == confirmpassword.text.toString()) {
                    val userInfo  = Info(name.text.toString(),id2.text.toString(),password2.text.toString())
                    intent.putExtra("UserInfo", userInfo) // user의 data class를 전달,
                    // 정보 받는방법  val user = intent.getSerializableExtra("object") as User?
                   //intent.putExtra("id_back", id2.text.toString())                    // 아이디 전달
                    //intent.putExtra("password_back", password2.text.toString())        // 비밀번호 전달
//                    setResult(
//                        RESULT_OK,
//                        intent
                    // RESULT_OK 전달하여 ActivityResult 수신 구문 실행

                    finish()
                }
                else
                    Toast.makeText(this@JoinActivity, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this@JoinActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()

        }//하나라도 입력되지 않은 정보가 있을경우 경고메시지를 띄운다.

    }
}
