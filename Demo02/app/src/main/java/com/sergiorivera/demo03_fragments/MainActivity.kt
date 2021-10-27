package com.sergiorivera.demo03_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.container, UserListFragment(), "UserListFragment")
            .commit()

        findViewById<TextView>(R.id.tv_bottom_bar).setOnClickListener {
            val fg = UserDetailFragment()
            val bundle = Bundle()
            bundle.putString("userId", "1")
            fg.arguments = bundle
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.container, fg, "UserDetailFragment")
            }

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.container, fg, "UserDetailFragment")
            }
        }
    }
}