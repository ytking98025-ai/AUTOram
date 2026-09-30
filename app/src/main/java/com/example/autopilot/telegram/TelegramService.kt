package com.example.autopilot.telegram

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaType
import org.json.JSONObject
import java.net.URLEncoder

object TelegramService {
    private val client = OkHttpClient()

    fun sendMessage(token: String, chatId: String, text: String): String {
        return try {
            val url = "https://api.telegram.org/bot$token/sendMessage"
            val body = JSONObject()
                .put("chat_id", chatId)
                .put("text", text)
                .toString()
                .toRequestBody("application/json".toMediaType())

            val request = Request.Builder().url(url).post(body).build()
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) "Telegram OK"
                else "Telegram error: HTTP ${response.code}"
            }
        } catch (e: Exception) {
            "Telegram error: ${e.message}"
        }
    }

}
