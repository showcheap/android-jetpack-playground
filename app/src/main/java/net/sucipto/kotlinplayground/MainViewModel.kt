package net.sucipto.kotlinplayground

import android.os.Bundle
import androidx.lifecycle.*

class MainViewModel(private var count: Int = 0) : ViewModel(), LifecycleObserver{
    companion object {
        const val COUNT_KEY = "CountKey"
    }
    val changeNotifier = MutableLiveData<Int>()
    fun increment() { changeNotifier.value = ++count }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() { increment() }

    fun restoreState(inState: Bundle?) {
        inState?.let { count = inState.getInt(COUNT_KEY) }
    }

    fun saveState(outState: Bundle) {
        outState.putInt(COUNT_KEY, count)
    }
}