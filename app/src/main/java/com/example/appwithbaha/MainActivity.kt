package com.example.appwithbaha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appwithbaha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fromPresenter()
    }

    private fun fromPresenter() {
         binding.btnIncrement.setOnClickListener{
             presenter.incrementCount()
         }

        binding.btnDecrement.setOnClickListener{
            presenter.decrementCount()
        }
    }

    override fun updateCounter(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun toast(count:Int) {
        if(count == 10){
            Toast.makeText(this, "Поздравляем!!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun replaceColor(count:Int) {
        if(count == 15) {
            binding.tvCount.setTextColor(Color.RED)
        }else{
            binding.tvCount.setTextColor(Color.BLACK)
        }
    }

}