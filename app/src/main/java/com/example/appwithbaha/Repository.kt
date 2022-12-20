package com.example.appwithbaha

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repository {

    private val liveData = MutableLiveData<CounterModel>()
    private val model = CounterModel()
    private lateinit var view: CounterView

    fun incrementCount(): MutableLiveData<CounterModel> {
        model.increment()
        view.updateCounter(model.getCount())
        view.toast(model.getCount())
        view.replaceColor(model.getCount())
        return liveData
    }

    fun decrementCount() : MutableLiveData<CounterModel>{
        model.decrement()
        view.updateCounter(model.getCount())
        view.toast(model.getCount())
        view.replaceColor(model.getCount())
        return liveData
    }

    fun attachView(view: CounterView) : MutableLiveData<CounterModel>{
        this.view = view
        return liveData
    }
}