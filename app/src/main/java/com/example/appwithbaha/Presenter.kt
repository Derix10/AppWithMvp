package com.example.appwithbaha

class Presenter {

    private val model = CounterModel()

    private lateinit var view: CounterView

    fun incrementCount() {
        model.increment()
        view.updateCounter(model.getCount())
        view.toast(model.getCount())
        view.replaceColor(model.getCount())
    }

    fun decrementCount() {
        model.decrement()
        view.updateCounter(model.getCount())
        view.toast(model.getCount())
        view.replaceColor(model.getCount())

    }

    fun attachView(view: CounterView) {
        this.view = view
    }
}