package net.sucipto.kotlinplayground.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.detail_fragment.*
import net.sucipto.kotlinplayground.R
import net.sucipto.kotlinplayground.entity.Person
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

//    companion object {
//        fun newInstance() = DetailFragment()
//    }

    private val viewModel: DetailViewModel by viewModel()
    val args by navArgs<DetailFragmentArgs>()
    private lateinit var person:Person


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.detail_fragment, container, false)
        view.findViewById<Button>(R.id.detail_btn_edit).setOnClickListener {
            val action = DetailFragmentDirections.editPersonAction(person.id!!)
            findNavController().navigate(action)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.load(args.personId)

        viewModel.getPerson(args.personId).observe(this, Observer {
            detail_text_name.text = it.name
            detail_text_id.text = Integer.toString(it.id!!)

            person = it
        })

        (activity as DetailActivity).supportActionBar?.title = "Person Detail"

    }
}
