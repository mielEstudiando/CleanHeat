package com.miel.cleanheat
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder

class Get {
    fun main() {
        val client = OkHttpClient()

        val baseUrl = "http://44.196.28.131:8081/eventsGet"

        // JSON que deseamos enviar
        val json = """
        {
            "ID": "TrangenderMindControl",
        }
    """.trimIndent()

        // Codificar el JSON como parte de la URL
        val encodedJson = URLEncoder.encode(json, "UTF-8")

        // Construir la URL con el JSON codificado
        val url = "$baseUrl?json_data=$encodedJson"

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        try {
            val response: Response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val responseData = response.body?.string()
                println("Respuesta exitosa: $responseData")
            } else {
                println("Error en la solicitud: ${response.code}")
            }
        } catch (e: IOException) {
            println("Excepción: ${e.message}")
        }
    }
}