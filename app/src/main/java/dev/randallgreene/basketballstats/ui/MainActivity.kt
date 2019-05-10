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
        val r = Thread(Runnable {

            val doc = Jsoup.connect("https://www.basketball-reference.com/players/n/nashst01.html").get()

            val regular = HtmlParser.parsePlayerSeasonsPerGame(doc)


            Log.v("hehehe", regular.toString())

        })

        r.start()

        /*val f = baseContext!!.assets.open(file)
        val doc = Jsoup.parse(f, null, f.toString())

        val regular = HtmlParser.parsePlayerSeasonsPerGame(doc)
        val post = HtmlParser.parsePlayerPlayoffsPerGame(doc) //  not working

        Log.v("hehehe", regular.toString())
        Log.v("hehehe", post.toString())*/
    }
}
