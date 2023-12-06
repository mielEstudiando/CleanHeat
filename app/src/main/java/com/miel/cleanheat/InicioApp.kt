package com.miel.cleanheat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class InicioApp : AppCompatActivity(), Get.OnRequestCompleteListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_app)
        val estado = findViewById<Button>(R.id.gotoStatus)
        estado.setOnClickListener {
            val getAsyncTask = Get(this)
            getAsyncTask.execute()
            val datos = findViewById<TextView>(R.id.data)
            if (datos.visibility==View.INVISIBLE) {
                datos.visibility = View.VISIBLE
            }
        }
        val grafico = findViewById<Button>(R.id.gotoConfig)
        grafico.setOnClickListener{
            val intent = Intent(this, Grafico::class.java)
            startActivity(intent)
        }

    }

    override fun onRequestComplete(result: String?) {
        runOnUiThread {
            // Actualizar el TextView con la respuesta del GET
            val textView = findViewById<TextView>(R.id.data)
            textView.text = result ?: "No se pudo obtener la respuesta"
        }
    }

    override fun onRequestError(error: String?) {
        runOnUiThread {
            // Manejar el error en el TextView
            val textView = findViewById<TextView>(R.id.data)
            textView.text = "Error: $error"
        }
    }
}