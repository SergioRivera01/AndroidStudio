package com.sergiorivera.demo01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d( "demo01", "onCreate")

        val etName: EditText = findViewById(R.id.et_name)
        val etlastName : EditText = findViewById(R.id.et_lastName)
        val btnNext: Button = findViewById(R.id.btn_next)
        val tvShowMeTheMoney: TextView = findViewById(R.id.tv_show)
        val cbResponsable : CheckBox = findViewById(R.id.cb_responsable)



        btnNext.setOnClickListener {

            if(etName.text.toString().length >= 2){
                if(cbResponsable.isChecked){
                    val openResponsable = Intent(this, DetailResponsable::class.java)
                    startActivity(openResponsable)
                    var bundle = Bundle()
                    openResponsable.putExtra("name", etName.text.toString())
                    openResponsable.putExtra("lastName", etlastName.text.toString())
                    openResponsable.putExtra("enable", false)
                }else {
                    val openActivity = Intent(this, DetailActivity::class.java)
                    var bundle = Bundle()
                    openActivity.putExtra("name", etName.text.toString())
                    openActivity.putExtra("lastName", etlastName.text.toString())
                    openActivity.putExtra("enable", false)
                    startActivity(openActivity)}


            }else{
                tvShowMeTheMoney.text = "El nombre tiene que tener al menos tres caracteres"
            }
        }

    }

}

