package com.pruebakt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.pruebakt.Models.UsuariosModel

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnLogin: Button

    private lateinit var usuariosModel: UsuariosModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUsuario  = findViewById(R.id.txtUsuario)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin    = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            usuariosModel = UsuariosModel(txtUsuario.text.toString(), txtPassword.text.toString())
        }
    }
}