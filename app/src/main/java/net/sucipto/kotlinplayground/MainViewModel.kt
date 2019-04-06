package net.sucipto.kotlinplayground

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.sucipto.kotlinplayground.entity.Person

class MainViewModel(private var count: Int = 0) : ViewModel() {
    companion object {
        const val COUNT_KEY = "CountKey"
    }

    val personList = MutableLiveData<MutableList<Person>>()
    var personData = mutableListOf<Person>()

//    init {
//        personList.value = mutableListOf(Person("Test"))
//    }

    fun addPerson(person: Person) {
        personData.add(person)
        personList.value = personData
        Log.d("MV","addPerson ${person.name} Total data: ${personList.value?.size}")
    }

    fun restoreState(inState: Bundle?) {
        inState?.let { count = inState.getInt(COUNT_KEY) }
    }

    fun saveState(outState: Bundle) {
        outState.putInt(COUNT_KEY, count)
    }
}