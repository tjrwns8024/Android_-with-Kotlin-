package com.example.recycler_prac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (val context: Context, val nameList:ArrayList<Data>):
RecyclerView.Adapter<MainAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(context).inflate(R.layout.main_item, parent, false)
        return Holder(view)
    }
    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.connect(nameList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        val personPhoto = itemView?.findViewById<ImageView>(R.id.personPhoto)
        val name = itemView?.findViewById<TextView>(R.id.name)

        fun connect(data:Data, context: Context){
            if(data.image != ""){
                val id = context.resources.getIdentifier(data.image, "drawable", context.packageName)
                personPhoto?.setImageResource(id)
            }
            else
                personPhoto?.setImageResource(R.mipmap.ic_launcher)

            name?.text = data.name
        }
    }

}