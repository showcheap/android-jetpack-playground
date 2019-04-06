package net.sucipto.kotlinplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()
    private val changeObserver = Observer<Int> { value -> value?.let { incrementCount(value) }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.restoreState(savedInstanceState)

        viewModel.changeNotifier.observe(this, changeObserver)
        lifecycle.addObserver(viewModel)
        my_button.setOnClickListener { viewModel.increment() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState(outState)
    }

    private fun incrementCount (value : Int) {
        my_text.text = (value).toString()
    }
}
