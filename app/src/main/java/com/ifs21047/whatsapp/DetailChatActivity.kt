package com.ifs21047.whatsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_chat)

        // Lakukan inisialisasi view dan tambahkan logika sesuai kebutuhan
    }

    companion object {
        const val EXTRA_CHAT = "extra_chat"
    }
}
