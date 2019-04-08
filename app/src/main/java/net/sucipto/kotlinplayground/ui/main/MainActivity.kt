package net.sucipto.kotlinplayground.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.sucipto.kotlinplayground.R
import net.sucipto.kotlinplayground.entity.Person
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_main.apply {
            layoutManager = LinearLayoutManager(get())
            adapter = mainAdapter
        }

        mainAdapter.setDeleteListener { person -> onItemDelete(person) }

        viewModel.personList.observe(this, Observer { data ->
            Log.d("Observer", "Obs receive: ${data.size}")
            data.let { mainAdapter.setData(it) }
        })

        main_add_button.setOnClickListener {
            viewModel.addPerson(Person(null,main_edit_text.text.toString()))
            main_edit_text.setText("")
        }

        main_btn_clear.setOnClickListener {
            viewModel.clearPerson()
        }


    }

    private fun onItemDelete(person: Person) {
        viewModel.deletePerson(person)
    }

}
