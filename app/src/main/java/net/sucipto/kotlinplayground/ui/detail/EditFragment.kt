package net.sucipto.kotlinplayground.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.edit_fragment.*
import net.sucipto.kotlinplayground.R
import net.sucipto.kotlinplayground.entity.Person
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditFragment : Fragment() {

    private val args: EditFragmentArgs by navArgs()
    private val viewModel: EditViewModel by viewModel()
    private lateinit var person: Person

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("EditFragment", "Person args ${args.personId}")
        (activity as DetailActivity).supportActionBar?.title = "Edit Person"

        viewModel.getPerson(args.personId).observe(this, Observer {
            edit_edit_text.setText(it.name)
            person = it
        })

        edit_btn_save.setOnClickListener {
            person.name = edit_edit_text.text.toString()
            viewModel.saveEdit(person)

            findNavController().popBackStack()
        }

    }

}
