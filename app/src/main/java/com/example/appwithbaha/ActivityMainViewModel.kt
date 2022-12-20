package com.example.appwithbaha

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ActivityMainViewModel : ViewModel() {

    private val repository = Repository()


    fun incrementCount(): LiveData<CounterModel> {
        return repository.incrementCount()
    }

    fun decrementCount(): LiveData<CounterModel> {
        return repository.decrementCount()
    }

    fun attachView(view: CounterView) : LiveData<CounterModel>{
        return repository.attachView(view)
    }
}