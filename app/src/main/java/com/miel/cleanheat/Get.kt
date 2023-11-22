package com.miel.cleanheat
import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class Get(private val listener: OnRequestCompleteListener) :
    AsyncTask<Void, Void, String>() {

    interface OnRequestCompleteListener {
        fun onRequestComplete(result: String?)
        fun onRequestError(error: String?)
    }

    override fun doInBackground(vararg params: Void?): String? {
        val client = OkHttpClient()

        val url = "http://44.196.28.131:8081/events"

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        return try {
            val response: Response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body?.string() // Devuelve el JSON como String
            } else {
                null
            }
        } catch (e: IOException) {
            e.message
        }
    }

    override fun onPostExecute(result: String?) {
        if (result != null) {
            listener.onRequestComplete(result)
        } else {
            listener.onRequestError("Error en la solicitud")
        }
    }
}
