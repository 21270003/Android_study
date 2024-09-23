package com.example.android05

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var tvHello:TextView = findViewById<TextView>(R.id.tvHello)
        var btnHello:Button = findViewById<Button>(R.id.btnHello)
        btnHello.setOnClickListener{
            tvHello.setText("hahahah........")
        }

    }
}