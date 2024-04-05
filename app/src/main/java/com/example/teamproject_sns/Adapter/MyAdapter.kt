package com.example.teamproject_sns.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject_sns.MainInfo
import com.example.teamproject_sns.R

class MyAdapter (private val itemList:MutableList<MainInfo>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //ClickListener 추가하여 recyclerView 클릭시 이벤트 추가
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    //??
    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.img_main)
        val name: TextView = itemView.findViewById(R.id.rv_name)
        init {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }

    //아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return MyViewHolder(itemView,mListener)
    }

    //View에 들어갈 내용 입력
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
    }
    // 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }
}