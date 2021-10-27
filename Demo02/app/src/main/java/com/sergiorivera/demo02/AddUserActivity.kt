package com.sergiorivera.demo02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class AddUserActivity : AppCompatActivity() {
    private lateinit var tiFirstname: TextInputEditText
    private lateinit var tiLastname: TextInputEditText
    private lateinit var rgImages: RadioGroup
    private lateinit var rbImage1: RadioButton
    private lateinit var rbImage2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        tiFirstname = findViewById(R.id.ti_firstname)
        tiLastname = findViewById(R.id.ti_lastname)
        rgImages = findViewById(R.id.rg_images)
        rbImage1 = findViewById(R.id.rb_image1)
        rbImage2 = findViewById(R.id.rb_image2)
        val btnAñadir: Button = findViewById(R.id.btn_añadir)
        val btnAñadirySalir: Button = findViewById(R.id.btn_añadirysalir)
        val btnsalir: Button = findViewById(R.id.btn_salir)

        val rbGroup: RadioGroup = findViewById(R.id.rg_images)
        rbImage1 = findViewById(R.id.rb_image1)
        rbImage2 = findViewById(R.id.rb_image2)

        val ivImage1: ImageView = findViewById(R.id.iv_image1)
        val ivImage2: ImageView = findViewById(R.id.iv_image2)

        //Uso de glide resumido con la clase Extensions.kt

        ivImage1.imageFromUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Chuck_Norris_May_2015.jpg/330px-Chuck_Norris_May_2015.jpg")
        ivImage2.imageFromUrl("https://i.imgur.com/DvpvklR.png")


        btnAñadir.setOnClickListener {
            if (addUser()) {
                tiFirstname.text = null
                tiLastname.text = null
                tiFirstname.requestFocus()
            }
        }

        btnAñadirySalir.setOnClickListener {
                if (addUser()) {
                    finish()
                }
        }

        btnsalir.setOnClickListener {
            finish()
        }

    }

    private fun addUser(): Boolean {
        val firstname = tiFirstname.text.toString()
        val lastname = tiLastname.text.toString()

        if (firstname.length >= 3 && lastname.length >= 3) {
            val newUser = User(UUID.randomUUID().toString(), firstname, lastname)
            (application as App).users.add(newUser)
            return true
        } else {
            Toast.makeText(this, "Datos requeridos", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}