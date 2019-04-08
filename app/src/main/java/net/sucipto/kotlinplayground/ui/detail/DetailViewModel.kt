package net.sucipto.kotlinplayground.ui.detail

import androidx.lifecycle.ViewModel
import net.sucipto.kotlinplayground.data.PersonRepository

class DetailViewModel(private val personRepository: PersonRepository) : ViewModel() {

    fun getPerson(int: Int) = personRepository.find(int)
}
