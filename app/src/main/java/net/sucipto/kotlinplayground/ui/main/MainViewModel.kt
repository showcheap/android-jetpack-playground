package net.sucipto.kotlinplayground.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.sucipto.kotlinplayground.data.PersonRepository
import net.sucipto.kotlinplayground.entity.Person
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val repository: PersonRepository) : ViewModel() {

    private val job = Job()
    private val coroutineContext: CoroutineContext get() = job + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    val personList = repository.persons

    override fun onCleared() {
        super.onCleared()

        job.cancel()
    }

    fun addPerson(person: Person) = scope.launch(Dispatchers.IO) {
        repository.add(person)
    }

    fun clearPerson() = scope.launch(Dispatchers.IO) {
        repository.clear()
    }

    fun deletePerson(person: Person) = scope.launch(Dispatchers.IO) {
        repository.delete(person)
    }
}