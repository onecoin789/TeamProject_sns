package com.example.teamproject_sns


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.Adapter.RVMainContentAdapter
import com.example.teamproject_sns.Model.ContentModel

class MainActivity : AppCompatActivity() {

    private lateinit var memberButton1: ImageButton
    private lateinit var memberButton2: ImageButton
    private lateinit var memberButton3: ImageButton
    private lateinit var memberButton4: ImageButton
    private lateinit var memberButton5: ImageButton

    private var writingsItems = mutableListOf<ContentModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            }

            override fun onTextClick(position: Int) {
                val intent = Intent(baseContext,DetailActivity::class.java)
                startActivity(intent)
            }
        })

        recyclerBoardContent.adapter = rvBoardAdapter

        recyclerBoardContent.layoutManager = LinearLayoutManager(this)

    }


    private fun initView() {
        memberButton1 = findViewById(R.id.member1)
        memberButton1.setImageResource(R.drawable.ic_launcher_foreground)
        memberButton1.setOnClickListener {
            navigateToMyPageActivity()
        }

        memberButton2 = findViewById(R.id.member2)
        memberButton2.setImageResource(R.drawable.ic_launcher_foreground)
        // memberButton2 클릭 이벤트 제거
        // memberButton2.setOnClickListener {
        //     navigateToMyPageActivity()
        // }

        memberButton3 = findViewById(R.id.member3)
        memberButton3.setImageResource(R.drawable.ic_launcher_foreground)
        // memberButton3 클릭 이벤트 제거
        // memberButton3.setOnClickListener {
        //     navigateToMyPageActivity()
        // }

        memberButton4 = findViewById(R.id.member4)
        memberButton4.setImageResource(R.drawable.ic_launcher_foreground)
        // memberButton4 클릭 이벤트 제거
        // memberButton4.setOnClickListener {
        //     navigateToMyPageActivity()
        // }

        memberButton5 = findViewById(R.id.member5)
        memberButton5.setImageResource(R.drawable.ic_launcher_foreground)
        // memberButton5 클릭 이벤트 제거
        // memberButton5.setOnClickListener {
        //     navigateToMyPageActivity()
        // }
    }
    private fun navigateToMyPageActivity() {
        val intent = Intent(this, MyPageActivity::class.java)
        startActivity(intent)
    }
}