package com.example.autopilot

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.autopilot.telegram.TelegramService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val token = findViewById<EditText>(R.id.telegramToken)
        val chatId = findViewById<EditText>(R.id.telegramChatId)
        val endpoint = findViewById<EditText>(R.id.aiEndpoint)
        val key = findViewById<EditText>(R.id.aiKey)
        val status = findViewById<TextView>(R.id.status)

        findViewById<Button>(R.id.btnAccessibility).setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }

        findViewById<Button>(R.id.btnTestTelegram).setOnClickListener {
            val t = token.text.toString().trim()
            val c = chatId.text.toString().trim()
            if (t.isEmpty() || c.isEmpty()) {
                status.text = "Status: Token और Chat ID भरें"
                return@setOnClickListener
            }
            Thread {
                val result = TelegramService.sendMessage(t, c, "AutoPilot test message")
                runOnUiThread { status.text = "Status: $result" }
            }.start()
        }

        findViewById<Button>(R.id.btnStartMonitor).setOnClickListener {
            status.text = "Status: Accessibility service को Settings में enable करें"
        }
    }
}
