package dev.randallgreene.basketballstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jsoup.Jsoup



class MainActivity : AppCompatActivity() {

    private val file = "steveNash.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val f = baseContext!!.assets.open(file)
        val doc = Jsoup.parse(f, null, f.toString())

        val table = doc.select("table[id=per_game]")


        for(row in table.select("tr")) {
            val tds = row.select("td")
            if (tds.size > 6) {
                Log.d("output", tds[0].text() + ":" + tds[1].text() + " 3% = " + tds[12].text())
            }
        }

    }
}
