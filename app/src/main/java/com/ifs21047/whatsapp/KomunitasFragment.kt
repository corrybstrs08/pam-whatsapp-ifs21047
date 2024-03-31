package com.ifs21047.whatsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class KomunitasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_komunitas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // You can add code here to initialize views and handle any interactions

        // Example:
        // val imgGambar = view.findViewById<ImageView>(R.id.img_gambar)
        // val tvNama = view.findViewById<TextView>(R.id.tv_nama)

        // You can set click listeners or perform any other actions as needed
    }
}
