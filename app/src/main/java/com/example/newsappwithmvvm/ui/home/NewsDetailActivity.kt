package com.example.newsappwithmvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsappwithmvvm.R
import com.example.newsappwithmvvm.data.models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {

    var news_detail: Article ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        news_detail = intent.getSerializableExtra(Article.KEY_NEWS) as Article

        supportActionBar?.setTitle("News Detail")

       // var title = intent.getStringExtra("title")
        text_view_title.text = news_detail?.title

       // var desc = intent.getStringExtra("desc")
        text_view_desc.text = news_detail?.description

        //var author = intent.getStringExtra("author")
        text_view_author.text = news_detail?.author

        //var imageUrl = intent.getStringExtra("image")
        Picasso.get()
            .load(news_detail?.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(image_view_news_detail)
    }
}