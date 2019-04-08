package net.sucipto.kotlinplayground.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.sucipto.kotlinplayground.data.PersonRepository
import net.sucipto.kotlinplayground.entity.Person

class MainViewModel(private val repository: PersonRepository) : ViewModel() {


    val personList = repository.persons

    fun addPerson(person: Person) = viewModelScope.launch(Dispatchers.IO) {
        repository.add(person)
    }

    fun clearPerson() = viewModelScope.launch(Dispatchers.IO) {
        repository.clear()
    }

    fun deletePerson(person: Person) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(person)
    }
}