package com.pruebakt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var btnClickMe: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre = findViewById(R.id.txtNombre)
        btnClickMe = findViewById(R.id.btnClickMe)

        btnClickMe.setOnClickListener {
            if (txtNombre.text.isNotEmpty()) {
                showMessage()
            }
        }
    }

    private fun showMessage() {
        Toast.makeText(this, "Bienvenido " + txtNombre, Toast.LENGTH_SHORT).show()
    }
}