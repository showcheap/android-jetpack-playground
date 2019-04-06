package net.sucipto.kotlinplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.sucipto.kotlinplayground.entity.Person
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()
    lateinit var mainAdapter: MainAdapter
    lateinit var mPersonList: MutableList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.restoreState(savedInstanceState)
        mPersonList = mutableListOf()
        mainAdapter = MainAdapter(mPersonList)

        recycler_main.apply {
            layoutManager = LinearLayoutManager(get())
            adapter = mainAdapter
        }

        main_add_button.setOnClickListener {
            addName(main_edit_text.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState(outState)
    }

    private fun addName(name:String) {
        mPersonList.add(Person(name))
        mainAdapter.notifyDataSetChanged()
        Log.d("Main", "Data length: ${mPersonList.size}")
    }


}
