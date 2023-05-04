package com.example.odev4_haber.service

import android.os.StrictMode
import android.util.Log
import com.example.odev4_haber.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsService {

    var url = "https://www.haberler.com/"

    fun getNews() : List<News> {
        var newsList = mutableListOf<News>()

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val doc: Document = Jsoup.connect(url).timeout(15000).get()
        val elements: Elements = doc.getElementsByAttribute("data-headlinenumber")

        for(element in elements){
            val img = element.getElementsByTag("img")

            val src = img.attr("data-src")
            val href = element.attr("abs:href")
            val title = img.attr("alt")

            if(title != "" && href != "" && src != ""){
                Log.d("title", title.toString())
                Log.d("href", href.toString())
                Log.d("src", src.toString())
                val news = News(title,href,src)
                newsList.add(news)
            }
        }

        Log.d("list", newsList.toString())

        return newsList
    }

}