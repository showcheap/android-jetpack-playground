package net.sucipto.kotlinplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.sucipto.kotlinplayground.entity.Person

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var data = emptyList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val person: Person = data[position]
        holder.bind(person)
    }


    inner class MainHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_main, parent, false)) {

        private var mNameView: TextView = itemView.findViewById(R.id.item_main_name)

        fun bind(person: Person) {
            mNameView.text = person.name
        }

    }

    internal fun setData(data : List<Person>) {
        this.data = data
        notifyDataSetChanged()
    }
}