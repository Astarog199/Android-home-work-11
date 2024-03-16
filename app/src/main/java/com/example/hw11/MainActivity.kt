package com.example.hw11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext

import com.example.hw11.databinding.ActivityMainBinding






class MainActivity : AppCompatActivity() {

    lateinit var buttonSave: Button
    lateinit var buttonClear: Button
    lateinit var editText: EditText
    lateinit var textV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonSave = binding.buttonSave
        buttonClear = binding.buttonClear
        editText = binding.editText
        textV = binding.text

        val repository = Repository(this)

        buttonSave.setOnClickListener { v ->
            val text = editText.text.toString()
            repository.saveText(text)
            textV.text = repository.getText()
        }

        buttonClear.setOnClickListener {
            repository.clearText()
            textV.text = ""
        }



    }


}