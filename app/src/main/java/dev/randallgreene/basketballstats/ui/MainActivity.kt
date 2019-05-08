package dev.randallgreene.basketballstats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.randallgreene.basketballstats.R


class MainActivity : AppCompatActivity() {

    private val file = "steveNash.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
