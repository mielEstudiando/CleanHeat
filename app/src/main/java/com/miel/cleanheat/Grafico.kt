package com.miel.cleanheat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Grafico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)

        val webView: WebView = findViewById(R.id.grafico)
        webView.settings.javaScriptEnabled = true // Habilitar JavaScript (si es necesario)
        webView.loadUrl("file:///android_asset/grafico.html")
    }
}