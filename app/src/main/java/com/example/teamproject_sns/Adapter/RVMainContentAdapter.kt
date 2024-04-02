package com.example.teamproject_sns.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teamproject_sns.Model.ContentModel
import com.example.teamproject_sns.R

class RVMainContentAdapter(val context: Context, val List:MutableList<ContentModel>):RecyclerView.Adapter<RVMainContentAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_mainboard,parent,false)

        return ViewHolder(view)
    }

    interface ItemClickListener{
//        fun onClick(view:View,position: Int)
        fun onImageClick(position: Int)
        fun onTextClick(position: Int)
    }

    private var itemClickListener: ItemClickListener? = null

    fun setItemClickListener(listener: ItemClickListener) {
        this.itemClickListener = listener
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //뷰홀더에 데이터 바인드 & click 리스너 세팅
        holder.bindItems(List[position])
        holder.imageView.setOnClickListener {
            itemClickListener?.onImageClick(position)
        }
        holder.textView.setOnClickListener {
            itemClickListener?.onTextClick(position)
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }



    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val imageView: ImageView = itemView.findViewById(R.id.rvContentImg)
        val textView: TextView = itemView.findViewById(R.id.rvContentTitle)
        fun bindItems(item: ContentModel){
            val rvContent_img = itemView.findViewById<ImageView>(R.id.rvContentImg)
            val rvContent_title = itemView.findViewById<TextView>(R.id.rvContentTitle)

            rvContent_title.text = item.titleUrl

            //라이프사이클이 액티비티에 붙은 객체를 생성해야 할 때 액티비티 컨텍스트 사용
            Glide.with(context)
                .load(item.imgUrl)
                .into(rvContent_img)
        }
    }
}