package com.example.buttonspinnerapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        val items = arrayOf("Canada", "USA", "India", "U.K")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = items[position]
                textView.text = "Selected: $selectedItem"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                textView.text = "No item selected"
            }
        }

        button.setOnClickListener {
            val selectedItem = spinner.selectedItem.toString()
            Toast.makeText(this, "Button clicked! Selected: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}
