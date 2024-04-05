package com.example.teamproject_sns.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.MainInfo
import com.example.teamproject_sns.R

class MyPageAdapter(private val itemList: MutableList<MainInfo>) :
    RecyclerView.Adapter<MyPageAdapter.MyPageViewHolder>() {

        //ClickListener 추가하여 recyclerView 클릭시 이벤트 추가
        private lateinit var mListener : onItemClickListener
        interface onItemClickListener {
            fun onItemClick(position: Int)
        }
    //??
    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }
    // 레이아웃 내 View 연결
    class MyPageViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val my_Email = itemView.findViewById<TextView>(R.id.text_Item_Mail)
        val my_Image = itemView.findViewById<ImageView>(R.id.img_Item)
        val my_Til = itemView.findViewById<TextView>(R.id.text_Item_Text)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    //아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_mypage_item, parent, false)

        return MyPageViewHolder(itemView,mListener)
    }


    // View에 들어갈 내용 입력
    override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
        val item = itemList[position]
        holder.my_Image.setImageResource(item.image)
        holder.my_Email.text = item.email
        holder.my_Til.text = item.til
    }

    // 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }
}
