package com.sergiorivera.demo02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val users: MutableList<User>,
                  val onClickListener: (User) -> Unit): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view : View = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val user : User = users[position]

        holder.tvUsername.text = user.firstname
        holder.tvLastname.text = user.lastname
        Glide.with(holder.ivAvatar.context).load(user.imageUrl).into(holder.ivAvatar)

        holder.itemView.setOnClickListener{
            onClickListener(user)
        }
    }

    override fun getItemCount(): Int {
       return  users.size
    }


    fun addUser(user: User){
        users.add(user)
        notifyDataSetChanged()
    }

    fun deleteUser(user :User){
        users.remove(user)
        notifyDataSetChanged()
    }


    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var tvUsername :TextView = view.findViewById(R.id.tv_firstname)
        var tvLastname : TextView = view.findViewById(R.id.tv_lastname)
        var ivAvatar : ImageView = view.findViewById(R.id.iv_avatar)

    }




}
