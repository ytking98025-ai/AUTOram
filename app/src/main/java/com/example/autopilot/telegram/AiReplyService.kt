package com.example.autopilot.telegram

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaType
import org.json.JSONArray
import org.json.JSONObject

class AiReplyService(
    private val endpoint: String,
    private val apiKey: String
) {
    private val client = OkHttpClient()

    fun generateReply(userMessage: String, history: List<Pair<String, String>>): String {
        val messages = JSONArray()
        messages.put(JSONObject().put("role", "system")
            .put("content", "You are a helpful Telegram assistant. Reply naturally and concisely."))
        history.forEach {
            messages.put(JSONObject().put("role", it.first).put("content", it.second))
        }
        messages.put(JSONObject().put("role", "user").put("content", userMessage))

        val body = JSONObject()
            .put("model", "gpt-4o-mini")
            .put("messages", messages)
            .put("temperature", 0.7)
            .toString()
            .toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url(endpoint)
            .addHeader("Authorization", "Bearer $apiKey")
            .post(body)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return "AI error: HTTP ${response.code}"
            val json = JSONObject(response.body?.string() ?: "{}")
            return json.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content")
        }
    }

}
