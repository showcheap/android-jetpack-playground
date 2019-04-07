package net.sucipto.kotlinplayground

import androidx.lifecycle.ViewModel
import net.sucipto.kotlinplayground.data.PersonRepository
import net.sucipto.kotlinplayground.entity.Person

class MainViewModel(private val repository: PersonRepository) : ViewModel() {

    val personList = repository.persons

    fun addPerson(person: Person) {
        repository.add(person)
    }

    fun clearPerson() {
        repository.clear()
    }
}