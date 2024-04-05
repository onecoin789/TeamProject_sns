package com.example.teamproject_sns


import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.teamproject_sns.Model.Info
import java.io.IOException
import java.text.SimpleDateFormat

import android.text.TextWatcher
import android.text.Editable


class JoinActivity :checkValidation, AppCompatActivity() {

    val PERM_STORAGE = 9
    val PERM_CAMERA = 10
    val REQ_CAMERA = 11
    val REQ_GALLERY = 12

    //camera 버튼
    private lateinit var Buttontextcamera:TextView
    //갤러리 버튼
    private lateinit var galleryBtn:TextView

    private lateinit var profileImg:ImageView
    //선택된 이미지의 주소를 저장할 변수
    private var realUri: Uri? = null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //프로필 이미지 뷰 초기화
        profileImg = findViewById(R.id.profileImg)

        //camera 버튼 초기화
        Buttontextcamera = findViewById(R.id.Buttontextcamera)
        galleryBtn = findViewById(R.id.galleryBtn)

        //1. 공용저장소 권한이 있는지 확인
        requirePermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERM_STORAGE)


        val name = findViewById<EditText>(R.id.et_naming)

        val email = findViewById<EditText>(R.id.et_id2)
        val password = findViewById<EditText>(R.id.et_password2)
        val confirmpw = findViewById<EditText>(R.id.confirmpw)
        val btn_sign = findViewById<Button>(R.id.btn_signup2)

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            } //id 변경전
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            } //id 변경중
            override fun afterTextChanged(s: Editable?) {
                checkEmail(email)
            } //id 변경후
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            } //id 변경전
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            } //id 변경중
            override fun afterTextChanged(s: Editable?) {
                checkPw(password)
            } //id 변경후
        })

        confirmpw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            } //id 변경전
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            } //id 변경중
            override fun afterTextChanged(s: Editable?) {
                checkPw(confirmpw)
            } //id 변경후
        })


        btn_sign.setOnClickListener {
            if (nullCheck(name.toString()) || nullCheck(password.toString()) || nullCheck(confirmpw.toString()) || nullCheck(email.toString()))
                Toast.makeText(this@JoinActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            else if (!checkEmail(email))
                Toast.makeText(this@JoinActivity, "유효한 이메일을 입력하세요", Toast.LENGTH_SHORT).show()
            else if(!checkPw(password))
                Toast.makeText(this, "비밀번호가 강도가 낮습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show()
            else if(!checkConfirmPw(password,confirmpw))
                Toast.makeText(this@JoinActivity, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this, LoginActivity::class.java)
                val userInfo = Info(name.text.toString(), email.text.toString(), password.text.toString())
                intent.putExtra("name",userInfo.name)
                intent.putExtra("email",userInfo.email)
                intent.putExtra("password", userInfo.password)
                setResult(RESULT_OK, intent)
                finish()
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }


    }

    fun initViews(){
        //카메라 요청시 권한 체크 후 승인되면 카메라 열기
        Buttontextcamera.setOnClickListener {
            requirePermissions(arrayOf(Manifest.permission.CAMERA),PERM_CAMERA)
        }
        //이미지 버튼이 클릭되면 갤러리 열기
        galleryBtn.setOnClickListener {
            openGallery()

        }
    }

    //카메라에 찍은 사진을 저장하기 위한 uri를 넘겨준다.
    //3. 카메라에 찍은 사진을 저장하기위한 uri를 넘겨준다.
    @SuppressLint("SuspiciousIndentation")
    fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        createImageUri(newfileName(),"image/jpg")?.let {
                uri->
            realUri = uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT,realUri)
            startActivityForResult(intent,REQ_CAMERA)
        }
        startActivityForResult(intent,REQ_CAMERA)


    }

    //갤러리 오픈 로직
    fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent,REQ_GALLERY)
    }

    //원본 이미지를 저장할 Uri를 MediaStore(안드 데이터베이스)에 생성하는 메서드
    fun createImageUri(filename:String,mimeType:String):Uri?{
        val values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME,filename)
        values.put(MediaStore.Images.Media.MIME_TYPE,mimeType)

        //파일을 저장할 수 있는 uri를 나에게 넘겨줌
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
    }
    //파일 이름을 생성하는 메서드
    fun newfileName():String{
        val sdf = SimpleDateFormat("yyyyMMdd HHmmss")
        val filename = sdf.format(System.currentTimeMillis())
        return "${filename}.jpg"
    }

    //원본 이미지를 불러오는 메서드
    @RequiresApi(Build.VERSION_CODES.P)
    fun loadBitmap(photoUri: Uri): Bitmap?{
        // var image:Bitmap? = null
        try {
            return if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                val source = ImageDecoder.createSource(contentResolver,photoUri)
                ImageDecoder.decodeBitmap(source)
            }else{
                MediaStore.Images.Media.getBitmap(contentResolver,photoUri)
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
        return null
    }



    //권한승인 메서드
    fun permissionGranted(requestCode: Int){
        when(requestCode){
            PERM_STORAGE -> initViews()
            PERM_CAMERA -> openCamera()
        }
    }

    //권한거부 메서드
    fun permissionDenied(requestCode: Int){
        when(requestCode){
            PERM_STORAGE->{
                Toast.makeText(this,"공용 저장소 권한을 승인해야 앱을 사용할 수 있습니다",Toast.LENGTH_SHORT).show()
                finish()
            }
            PERM_CAMERA ->{
                Toast.makeText(this,"카메라 권한을 승인해야 카메라를 사용할 수 있습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    //4. 카메라를 찍은 후에 호출된다. 6. 갤러리에서 선택후 호출된다
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            when(requestCode){
                //카메라 요청
                REQ_CAMERA -> {

                    realUri?.let { uri ->
                        val bitmap = loadBitmap(uri)
                        profileImg.setImageBitmap(bitmap)
                        realUri = null
                    }

                }
                //갤러리 요청
                REQ_GALLERY ->{
                    data?.data?.let {
                            uri->
                        profileImg.setImageURI(uri)
                    }
                }
            }

        }
    }
    //권한 검사
    fun requirePermissions(permission:Array<String>,requestCode: Int){
        //API 버전이 마시멜로 이하이면 권한처리가 필요없다
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            permissionGranted(requestCode)
        }else{
            //권한이 없으면 권한 요청 -> 팝업
            ActivityCompat.requestPermissions(this,permission,requestCode)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults.all{it == PackageManager.PERMISSION_GRANTED}){
            permissionGranted(requestCode)
        }else{
            permissionDenied(requestCode)
        }
    }
}
