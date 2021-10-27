package com.sergiorivera.demo02

import android.app.Application
class App : Application() {
    val users: MutableList<User> = mutableListOf()

}