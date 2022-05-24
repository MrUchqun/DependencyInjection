package com.example.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.dependencyinjection.R
import com.example.dependencyinjection.utils.SampleClass
import com.example.dependencyinjection.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleClass: SampleClass

    // ViewModel by default initials value
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleClass.doSomeThing()
        viewModel.apiPostList()
    }
}