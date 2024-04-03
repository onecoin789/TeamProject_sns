package com.example.teamproject_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.Adapter.MyPageAdapter

class MyPageActivity : AppCompatActivity() {
    private var data: MyPageData = MyPageData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val btn_close = findViewById<ImageView>(R.id.img_My_Close);
        btn_close.setOnClickListener{
            finish()
        }
        val rv_Page = findViewById<RecyclerView>(R.id.rv_Page)

        val itemList = ArrayList<MyPageData>()
        itemList.add(MyPageData("onecoin"))
        itemList.add(MyPageData("onecoin"))
        itemList.add(MyPageData("onecoin"))


        val pageAdapter = MyPageAdapter(itemList)

        rv_Page.adapter = pageAdapter
        rv_Page.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}