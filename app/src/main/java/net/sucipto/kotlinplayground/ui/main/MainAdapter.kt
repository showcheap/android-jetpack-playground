package net.sucipto.kotlinplayground.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.sucipto.kotlinplayground.R
import net.sucipto.kotlinplayground.entity.Person

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var data = emptyList<Person>()
    private lateinit var deleteListener: (Person) -> Unit
    private lateinit var clickListener: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val person: Person = data[position]
        holder.mNameView.text = person.name
        holder.mNameId.text = "Person ID: ${person.id}"
        holder.mDeleteButton.setOnClickListener {
            deleteListener(person)
        }
        holder.itemView.setOnClickListener {
            clickListener(person.id!!)
        }

    }

    inner class MainHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_main, parent, false)) {

        var mNameView: TextView = itemView.findViewById(R.id.item_main_name)
        var mNameId: TextView = itemView.findViewById(R.id.item_main_id)
        var mDeleteButton: Button = itemView.findViewById(R.id.item_main_delete)

    }

    fun setData(data: List<Person>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun setDeleteListener(listener: (Person) -> Unit) {
        deleteListener = listener
    }

    fun setClickListener(listener: (Int) -> Unit) {
        clickListener = listener
    }
}