package com.example.teamproject_sns


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.Adapter.RVMainContentAdapter
import com.example.teamproject_sns.Model.ContentModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var memberButton1: ImageButton
    private lateinit var memberButton2: ImageButton
    private lateinit var memberButton3: ImageButton
    private lateinit var memberButton4: ImageButton
    private lateinit var memberButton5: ImageButton

    private var name:String? = null
    private var email:String? = null
    lateinit var image: Array<Int>

    private var writingsItems = mutableListOf<ContentModel>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LoginActivity에서 전달된 데이터 가져오기
        name = intent.getStringExtra("name")
        email = intent.getStringExtra("email")

        // TextView에 데이터 설정

        val nameTextView = findViewById<TextView>(R.id.addIcon1)
        nameTextView.text = name
        val emailTextView = findViewById<TextView>(R.id.email)
        emailTextView.text = email


        val logoutBtn = findViewById<TextView>(R.id.logoutBtn)

        logoutBtn.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }


        //프로필이미지 사진 삽입
        initView()

        //게시물 데이터 삽입
        writingsItems.add(
            ContentModel(
                "https://crablo12.tistory.com/110",
                "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FnJyhS%2FbtsF9fbq7VG%2FndTfxPMXYfK2RXTZdRKk5k%2Fimg.png",
                "title0"
            )
        )
        writingsItems.add(
            ContentModel(
                "https://jihyung1997.tistory.com/",
                "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FGYdoD%2FbtsGbRVqogP%2FPKIZe4Yvi5jK44inVOZeWk%2Fimg.png",
                "title1"
            )
        )
        writingsItems.add(
            ContentModel(
                "https://velog.io/@bettor/posts",
                "https://velog.velcdn.com/images/bettor/post/a851ddc6-4dd6-49c8-b5d0-5f3dfb7308fe/image.png",
                "title2"
            )
        )
        writingsItems.add(
            ContentModel(
                "https://velog.io/@godls20455/posts",
                "https://velog.velcdn.com/images/godls20455/post/bbefe551-9539-4061-b0c5-3f5fc7cdff7e/image.png",
                "title3"
            )
        )
        writingsItems.add(
            ContentModel(
                "https://velog.io/@one_coin/posts",
                "https://velog.velcdn.com/images/one_coin/post/c9d35389-b7fb-472b-b613-aa7e635d7d1e/image.png",
                "title4"
            )
        )
        writingsItems.add(
            ContentModel(
                "https://crablo12.tistory.com/",
                "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fc7lcrs%2FbtsGayCEjI6%2FjsEAOZcb4O3Diz5BgHI1N0%2Fimg.png",
                "title5"
            )
        )


        //프로필 및 게시글

        val recyclerBoardContent = findViewById<RecyclerView>(R.id.recyclerViewVertical)

        val rvBoardAdapter = RVMainContentAdapter(baseContext,writingsItems)


        rvBoardAdapter.setItemClickListener(object : RVMainContentAdapter.ItemClickListener{
            override fun onImageClick(position: Int) {
                val intent = Intent(baseContext,WebViewActivity::class.java)
                intent.putExtra("url",writingsItems[position].url)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }

            override fun onTextClick(position: Int) {
                val intent = Intent(baseContext,DetailActivity::class.java)
                //LoginActivity에서 전달된 데이터를 가져옴-이름,이메일
                // name = intent.getStringExtra("name")
                email = intent.getStringExtra("email")


                //DetailActivity로 데이터를 전달-이름,이메일
                // intent.putExtra("name",name)
                intent.putExtra("email",email)

                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        })

        recyclerBoardContent.adapter = rvBoardAdapter

        recyclerBoardContent.layoutManager = LinearLayoutManager(this)

    }


    private fun initView() {
        image = arrayOf(
            R.drawable.one
        )
        memberButton1 = findViewById(R.id.member1)
        memberButton1.setImageResource(R.drawable.one)
        memberButton1.setOnClickListener {
            val intent = Intent(this@MainActivity, MyPageActivity::class.java)
            intent.putExtra("image", image[0])
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        //랜덤 이미지 출력구간
        val memberImage1 = findViewById<ImageView>(R.id.member2)
        randomImage(memberImage1)
        val memberImage2 = findViewById<ImageView>(R.id.member3)
        randomImage(memberImage2)
        val memberImage3 = findViewById<ImageView>(R.id.member4)
        randomImage(memberImage3)
        val memberImage4 = findViewById<ImageView>(R.id.member5)
        randomImage(memberImage4)

//        memberButton2 = findViewById(R.id.member2)
//        memberButton2.setImageResource(R.drawable.three)
//        // memberButton2 클릭 이벤트 제거
//        // memberButton2.setOnClickListener {
//        //     navigateToMyPageActivity()
//        // }
//
//        memberButton3 = findViewById(R.id.member3)
//        memberButton3.setImageResource(R.drawable.four)
//        // memberButton3 클릭 이벤트 제거
//        // memberButton3.setOnClickListener {
//        //     navigateToMyPageActivity()
//        // }
//
//        memberButton4 = findViewById(R.id.member4)
//        memberButton4.setImageResource(R.drawable.five)
//        // memberButton4 클릭 이벤트 제거
//        // memberButton4.setOnClickListener {
//        //     navigateToMyPageActivity()
//        // }
//
//        memberButton5 = findViewById(R.id.member5)
//        memberButton5.setImageResource(R.drawable.six)
//        // memberButton5 클릭 이벤트 제거
//        // memberButton5.setOnClickListener {
//        //     navigateToMyPageActivity()
//        // }

    }
    private fun navigateToMyPageActivity() {
        val intent = Intent(this, MyPageActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    //랜덤 이미지 목록
    val imageArray = arrayOf(
        R.drawable.one,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six
    )
    private fun randomImage(imageView: ImageView) {
        val randomIndex = (imageArray.indices).random()
        val imageResourceId = imageArray[randomIndex]
        imageView.setImageResource(imageResourceId)
    }

}