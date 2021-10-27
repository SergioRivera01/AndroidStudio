package com.sergiorivera.demo02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val tvLabelName : TextView = findViewById(R.id.tv_labelName)
        val tvLabelLastName : TextView = findViewById(R.id.tv_labellastname)
        val btnBack : Button = findViewById(R.id.btn_atras)
        val ivAvatar : ImageView? = findViewById(R.id.iv_avatar)

        val userId : String? = intent.extras?.getString("userId")

        btnBack.setOnClickListener {
            finish()
        }

        if(userId == null ){
            Log.d("DetailUser", "userId == null")
            finish()
        }

        // var user: User? = null
        // (application as App).users.forEach { forUser ->
        //     if(forUser.id == userId){
        //         user = forUser
        //         return@forEach
        //     }
        // }


        // Hace lo mismo que lo de arriba pero con menos codigo

         val user = (application as App).users.firstOrNull { forUser -> forUser.id == userId }

        if(user == null ){
            Log.d("DetailUser", "userId == null")
            finish()
        }

        tvLabelName.text = user?.firstname
        tvLabelLastName.text = user?.lastname

        if (ivAvatar != null) {
            ivAvatar.imageFromUrl(user?.imageUrl!!)
        }
    }
}