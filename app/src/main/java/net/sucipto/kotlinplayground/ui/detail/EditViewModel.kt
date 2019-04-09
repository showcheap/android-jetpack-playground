package net.sucipto.kotlinplayground.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import net.sucipto.kotlinplayground.data.PersonRepository
import net.sucipto.kotlinplayground.entity.Person

class EditViewModel(private val personRepository: PersonRepository) : ViewModel() {
    private var loadingState = MutableLiveData<Int>()
    fun getPerson(int: Int) = personRepository.find(int)

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun saveEdit(person: Person) =  viewModelScope.launch(Dispatchers.IO) {
        val updated = personRepository.update(person)
        Log.d("EditViewModel", "Updted person $updated")


        // Sample switching to main thread
        withContext(Dispatchers.Main){
            loadingState.value = 1
        }
    }
}
