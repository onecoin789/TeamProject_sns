package com.example.teamproject_sns.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.DetailActivity
import com.example.teamproject_sns.MyPageData
import com.example.teamproject_sns.R

class MyPageAdapter(val itemList: MutableList<MyPageData>) :
    RecyclerView.Adapter<MyPageAdapter.MyPageViewHolder>() {

    //아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_page_item, parent, false)
        return MyPageViewHolder(view)
    }

    // View에 들어갈 내용 입력
    override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    // 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }

    // 레이아웃 내 View 연결
    inner class MyPageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_mail = itemView.findViewById<TextView>(R.id.text_Item_Mail)


        fun bind(itemList: MyPageData) {
            tv_mail.text = itemList.mail
        }
    }
}
