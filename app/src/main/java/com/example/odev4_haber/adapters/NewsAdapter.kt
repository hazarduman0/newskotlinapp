package com.example.odev4_haber.adapters

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.odev4_haber.R
import com.example.odev4_haber.models.News

class NewsAdapter(private val context: Activity, private val list: List<News>) : ArrayAdapter<News>(context, R.layout.news_card, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(R.layout.news_card,null,true)
        val r_news_image = view.findViewById<ImageView>(R.id.newsImage)
        val r_news_header = view.findViewById<TextView>(R.id.newsHeader)

        val news = list.get(position)

        Glide.with(view).load(news.src).into(r_news_image)
        r_news_header.text = news.title

        return view
    }

}