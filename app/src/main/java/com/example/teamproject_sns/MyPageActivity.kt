package com.example.teamproject_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.Adapter.MyPageAdapter

class MyPageActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<MainInfo>
    lateinit var image: Array<Int>
    lateinit var name: Array<String>
    lateinit var email: Array<String>
    lateinit var til: Array<String>
    lateinit var text: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)


        //각 위치에 맞게 값 대입해주기
        val imageMy = findViewById<ImageView>(R.id.img_My_Main)
        val nameMy = findViewById<TextView>(R.id.text_My_Name)
        val emailMy = findViewById<TextView>(R.id.text_My_Email)

        val bundle: Bundle? = intent.extras
        val imageGet = bundle!!.getInt("image")
        val nameGet = bundle?.getString("name")
        val emailGet = bundle?.getString("email")

        imageMy.setImageResource(imageGet)
        nameMy.text = nameGet
        emailMy.text = emailGet


        //Main에서 받아온 데이터 그대로 넣기
        image = arrayOf(
            imageGet,
            imageGet,
            imageGet
        )
        name = arrayOf(
            nameGet.toString(),
            nameGet.toString(),
            nameGet.toString()
        )
        email = arrayOf(
            emailGet.toString(),
            emailGet.toString(),
            emailGet.toString()
        )

        til = arrayOf(
            "TIL1",
            "TIL2",
            "TIL3"
        )







        newRecyclerView = findViewById(R.id.rv_Page)
        newRecyclerView.layoutManager =
            LinearLayoutManager(this@MyPageActivity, LinearLayoutManager.VERTICAL, false)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<MainInfo>()
        getUserData()


        val btn_close = findViewById<ImageView>(R.id.img_My_Close);
        btn_close.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        }
    }
    private fun getUserData() {

        for (i in image.indices) {

            val info = MainInfo(image[i], name[i], email[i],til[i])
            newArrayList.add(info)

            //intent로 DetailActivity에 정보 전달
            val adapter = MyPageAdapter(newArrayList)
            newRecyclerView.adapter = adapter
            adapter.setOnItemClickListener(object : MyPageAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
//                    Toast.makeText(this@MyPageActivity, "확인",Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@MyPageActivity, DetailActivity::class.java)
                    intent.putExtra("image",newArrayList[position].image)
                    intent.putExtra("email",newArrayList[position].email)
                    intent.putExtra("name",newArrayList[position].name)
                    intent.putExtra("til",newArrayList[position].til)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }
            })
        }
    }
}




//        val itemList = ArrayList<MainInfo>()
//        itemList.add(MainInfo(image, "asd","asd"))
//
//
//        val pageAdapter = MyPageAdapter(itemList)
//
//        rv_Page.adapter = pageAdapter
//        rv_Page.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//    }
//}