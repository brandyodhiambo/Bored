package com.odhiambodevelopers.bored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.odhiambodevelopers.bored.databinding.ActivityMainBinding
import com.odhiambodevelopers.bored.util.Resource
import com.odhiambodevelopers.bored.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeToObserver()
        binding.btnClick.setOnClickListener {

            viewModel.getAnActivity()
        }
    }

    private fun subscribeToObserver(){
        viewModel.activityResult.observe(this, Observer { activity ->
            when(activity){
                is Resource.Success ->{
                    binding.progressBar.isVisible = false

                    binding.textViewActivityValue.text = activity.data?.activity
                    binding.textViewTypeValue.text = activity.data?.type
                    binding.textViewParticipantsValue.text = activity.data?.participants.toString()
                    binding.textViewPriceValue.text = activity.data?.price.toString()
                }
                is Resource.Loading ->{
                    binding.progressBar.isVisible = true
                }
                is Resource.Failure ->{
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, activity.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}