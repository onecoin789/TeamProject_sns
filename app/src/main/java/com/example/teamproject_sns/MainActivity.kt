package com.example.teamproject_sns


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.Adapter.MyAdapter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<MainInfo>
    lateinit var image : Array<Int>
    lateinit var name : Array<String>
    lateinit var email : Array<String>
    lateinit var til : Array<String>
    lateinit var text : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //mainPage 구성
        image = arrayOf(
            R.drawable.one,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
        )
        name = arrayOf(
            "asd1",
            "asd2",
            "asd3",
            "asd4",
            "asd5"
        )
        email = arrayOf(
            "asd1@naver.com",
            "asd2@naver.com",
            "asd3@naver.com",
            "asd4@naver.com",
            "asd5@naver.com"
        )
        til = arrayOf(
            "TIL1",
            "TIL2",
            "TIL3",
            "TIL4",
            "TIL5"
        )
        text = arrayOf(
            "소개1",
            "소개2",
            "소개3",
            "소개4",
            "소개5"
        )


        //newRecyclerView 설정
        newRecyclerView = findViewById(R.id.rv_Main)
        newRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<MainInfo>()
        getUserData()

    }

    //index에 맞는 이미지와 정보 출력
    private fun getUserData() {

        for(i in image.indices) {

            val info = MainInfo(image[i],name[i],email[i], til[i],text[i])
            newArrayList.add(info)
        }

        //각 정보 MyPage로 넘겨주기
        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, MyPageActivity::class.java)
                intent.putExtra("image", newArrayList[position].image)
                intent.putExtra("name", newArrayList[position].name)
                intent.putExtra("email", newArrayList[position].email)
                intent.putExtra("til", newArrayList[position].til)
                intent.putExtra("text", newArrayList[position].text)
                startActivity(intent)
            }
        })
    }
}
