package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button) //Initial data of ADD 1
        val textView = findViewById<TextView>(R.id.textView)

        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            Toast.makeText(it.context, "You added 1", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()

            if(counter >= 100) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "ADD 2"

                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}