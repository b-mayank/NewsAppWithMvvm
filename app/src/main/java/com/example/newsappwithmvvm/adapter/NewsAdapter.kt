package com.example.newsappwithmvvm.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappwithmvvm.R
import com.example.newsappwithmvvm.data.models.Article
import com.example.newsappwithmvvm.ui.home.NewsDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_row_news.view.*

class NewsAdapter(var mContext:Context):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var mList:ArrayList<Article> = ArrayList()

    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun bind (article: Article){

            itemView.text_view_title.text = article.title
            Picasso.get()
                .load(article.urlToImage)
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.image_view_news)

            itemView.setOnClickListener {
//

                Toast.makeText(mContext,"Hello",Toast.LENGTH_LONG).show()
            }

            itemView.setOnClickListener {
                Toast.makeText(mContext,"Hello",Toast.LENGTH_SHORT).show()
                var intent = Intent(mContext,NewsDetailActivity::class.java)
//                intent.putExtra("image",article.urlToImage)
//                intent.putExtra("title",article.title)
//                intent.putExtra("desc",article.description)
//                intent.putExtra("author",article.author)

                  intent.putExtra(Article.KEY_NEWS,article)

                mContext.startActivity(intent)
            }

        }
    }




    fun setData(list: ArrayList<Article>){
        mList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.single_row_news,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = mList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}