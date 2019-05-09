package dev.randallgreene.basketballstats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.data.parsing.HtmlParser
import org.jsoup.Jsoup


class MainActivity : AppCompatActivity() {

    private val file = "steveNash.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for testing
        val f = baseContext!!.assets.open(file)
        val doc = Jsoup.parse(f, null, f.toString())

        val regular = HtmlParser.parsePlayerSeasonsPerGame(doc)
        val post = HtmlParser.parsePlayerPlayoffsPerGame(doc)

        Log.v("hehehe", regular.toString())
        Log.v("hehehe", post.toString())
    }
}
