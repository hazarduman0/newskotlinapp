package com.example.odev4_haber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ListView
import com.example.odev4_haber.adapters.NewsAdapter
import com.example.odev4_haber.service.NewsService

class MainActivity : AppCompatActivity() {

    lateinit var newsListView : ListView

    val newsService = NewsService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsListView = findViewById(R.id.newsListView)

        val newsAdapter = NewsAdapter(this, newsService.getNews())
        newsListView.adapter = newsAdapter

        newsListView.setOnItemClickListener { adapterView, view, i, l ->
            val url = newsService.getNews()[i].href

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }

    }
}