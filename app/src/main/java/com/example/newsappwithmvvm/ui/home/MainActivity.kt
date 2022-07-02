package com.example.newsappwithmvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappwithmvvm.R
import com.example.newsappwithmvvm.adapter.NewsAdapter
import com.example.newsappwithmvvm.data.models.Article
import com.example.newsappwithmvvm.data.models.NewsResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter
    var mList : ArrayList<Article> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        init()
    }

    private fun init() {


        getData()
        newsAdapter = NewsAdapter(this)
        recycler_view.adapter = newsAdapter
        recycler_view.layoutManager  = LinearLayoutManager(this)



    }

    private fun getData(){
        var myViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        var liveData =  myViewModel.getNews()


        liveData.observe(this, object: Observer<NewsResponse>{
            override fun onChanged(t: NewsResponse?) {
                mList = t!!.articles
                newsAdapter.setData(t.articles)
            }

        })

    }
}
