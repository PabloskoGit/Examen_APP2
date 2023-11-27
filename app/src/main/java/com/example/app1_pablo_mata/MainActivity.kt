package com.example.app1_pablo_mata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numRecibir = findViewById<EditText>(R.id.etNumeros)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {

            val myIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, numRecibir.text)
                type = "text/plain"
            }

            // Create intent to show the chooser dialog
            val chooser: Intent = Intent.createChooser(myIntent, "Enviar Datos a APP2")

            // Verify the original intent will resolve to at least one activity
            if (myIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }
    }
}