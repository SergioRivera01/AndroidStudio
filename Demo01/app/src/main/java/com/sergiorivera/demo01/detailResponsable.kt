package com.sergiorivera.demo01

import android.app.AppComponentFactory
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailResponsable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reponsable)

        val btncontinuar : Button = findViewById(R.id.bt_continuar)

        btncontinuar.setOnClickListener {
            val openActivity = Intent(this, DetailActivity::class.java)


            startActivity(openActivity)
        }
    }

}
