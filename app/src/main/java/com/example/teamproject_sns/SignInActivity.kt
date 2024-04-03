package com.example.teamproject_sns

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val name = findViewById<EditText>(R.id.edit_Name)
        val mail = findViewById<EditText>(R.id.edit_Mail)
        val password = findViewById<EditText>(R.id.edit_Password)
        val password_Confirm = findViewById<EditText>(R.id.edit_Password_Confirm)


        val btn_Done = findViewById<Button>(R.id.btn_In_Done)
        btn_Done.setOnClickListener {
            if (name.text.toString().isEmpty() && mail.text.toString().isEmpty() &&
                password.text.toString().isEmpty() && password_Confirm.text.toString().isEmpty()
            ) {
                Toast.makeText(this@SignInActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else if (password.text.toString() != password_Confirm.text.toString()) {
                Toast.makeText(this@SignInActivity, "비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {

                val userInfo =
                    UserInfo(name.text.toString(), mail.text.toString(), password.text.toString())

                intent.putExtra("UserInfo", userInfo)// user의 data class를 전달,
                // 정보 받는방법  val user = intent.getSerializableExtra("object") as User?
                //intent.putExtra("id_back", id2.text.toString())                    // 아이디 전달
                //intent.putExtra("password_back", password2.text.toString())        // 비밀번호 전달
                //setResult(
                //RESULT_OK,
                //intent
                // RESULT_OK 전달하여 ActivityResult 수신 구문 실행
                finish()
            }

        }


        val btn_Close = findViewById<ImageView>(R.id.img_In_Close)
        btn_Close.setOnClickListener {
            finish()
        }

        //버튼 이벤트
        val btn_Galley = findViewById<Button>(R.id.btn_In_Main)
        btn_Galley.setOnClickListener {

            //갤러리 호출
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityResult.launch(intent)
        }
    }

    //결과 가져오기
    private val activityResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            //결과 코드 OK, 결과값 null 아니면
            if (it.resultCode == RESULT_OK && it.data != null) {
                //값 담기
                var uri: Uri? = null
                val imageView = findViewById<ImageView>(R.id.img_In_Main)
                uri = it.data?.data
                imageView.clipToOutline = true

                //화면에 뿌려주기
                Glide.with(this)
                    .load(uri)
                    .into(imageView)
            }
        }
}