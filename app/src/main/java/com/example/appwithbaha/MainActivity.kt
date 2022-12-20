package com.example.appwithbaha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.appwithbaha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ActivityMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.attachView(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fromPresenter()
    }



    private fun fromPresenter() {
         binding.btnIncrement.setOnClickListener{
             viewModel.incrementCount()
         }

        binding.btnDecrement.setOnClickListener{
            viewModel.decrementCount()
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