package net.sucipto.kotlinplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.sucipto.kotlinplayground.entity.Person

class MainAdapter(private val list: List<Person>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val person: Person = list[position]
        holder.bind(person)
    }


    class MainHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_main, parent, false)) {

        private var mNameView: TextView = itemView.findViewById(R.id.item_main_name)

        fun bind(person: Person) {
            mNameView.text = person.name
        }

    }
}