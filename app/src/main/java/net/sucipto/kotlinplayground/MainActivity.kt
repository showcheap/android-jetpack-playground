package net.sucipto.kotlinplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.sucipto.kotlinplayground.entity.Person
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.restoreState(savedInstanceState)

        recycler_main.apply {
            layoutManager = LinearLayoutManager(get())
            adapter = mainAdapter
        }

        viewModel.personList.observe(this, Observer { data ->
            Log.d("Observer", "Obs receive: ${data.size}")
            data.let { mainAdapter.setData(it) }
        })

        main_add_button.setOnClickListener {
            addName(main_edit_text.text.toString())
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState(outState)
    }

    private fun addName(name: String) {
        viewModel.addPerson(Person(name))
        main_edit_text.setText("")
    }


}
