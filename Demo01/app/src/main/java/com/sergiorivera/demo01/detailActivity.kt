package com.sergiorivera.demo01

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvname : TextView = findViewById(R.id.tv_name)
        val tvlastname : TextView = findViewById(R.id.tv_last_name)
        val ivavatar : ImageView = findViewById(R.id.iv_avatar)
        val swcommertial : Switch = findViewById(R.id.sw_comertial)
        val tvdepartamento : TextView = findViewById(R.id.tv_departamento)

        val btnconfirmed : Button = findViewById(R.id.btn_confirm)
        val btnrequired : Button = findViewById(R.id.btn_required)

        val namepassed : String? = intent.extras?.getString("name")
        val lastNamepassed : String? = intent.extras?.getString("lastName")
        val depatamentopassed : String? = intent.extras?.getString("departamento")



        tvdepartamento.text = depatamentopassed
        tvname.text = namepassed
        tvlastname.text = lastNamepassed

        btnconfirmed.setOnClickListener {
            Toast.makeText(this, "Activado", Toast.LENGTH_SHORT).show()
        }

        swcommertial.setOnCheckedChangeListener { buttonView ,isChecked -> btnrequired.isEnabled = isChecked}

        btnrequired.setOnClickListener{
            Toast.makeText(this, "Activado", Toast.LENGTH_SHORT).show()
        }
    }
}