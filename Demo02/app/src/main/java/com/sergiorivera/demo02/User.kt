package com.sergiorivera.demo02

data class User(
    val id: String,
    val firstname: String,
    val lastname: String,
    val imageUrl: String? = null
)

fun UserResponse.toUser(): User {
    return User(
        this.email,
        this.name.first,
        this.name.last,
        this.picture.medium
    )
}

fun List<UserResponse>.toUser(): List<User>{
    return this.map { it.toUser() }
}
