package com.sergiorivera.demo02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddUser: Button = findViewById(R.id.btn_AddUser)
        val rvUsers: RecyclerView = findViewById(R.id.rv_users)

        val app = application as App
        var users = app.users


        val gson: Gson = Gson()
        val results = gson.fromJson(FakeData.usersJson, ResultResponse::class.java)

        users.addAll(results.users.toUser())
        results.users.forEach { userResponse ->
            users.add(userResponse.toUser())
        }


        adapter = UserAdapter(users) { user ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("userId", user.id)
            startActivity(intent)
        }
        rvUsers.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvUsers.layoutManager = layoutManager


        btnAddUser.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}