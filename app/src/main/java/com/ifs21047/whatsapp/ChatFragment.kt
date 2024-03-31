package com.ifs21047.whatsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21047.whatsapp.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val dataChat = ArrayList<Chat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvChat.setHasFixedSize(false)
        dataChat.addAll(getListChat())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListChat(): ArrayList<Chat> {
        val dataNama =
            resources.getStringArray(R.array.nama)
        val dataGambar =
            resources.obtainTypedArray(R.array.gambar_profil)
        val dataDescription =
            resources.getStringArray(R.array.pesan)
        val dataTanggal =
            resources.getStringArray(R.array.tanggal)
        val listChat = ArrayList<Chat>()
        for (i in dataNama.indices) {
            val chat = Chat(dataNama[i],
                dataGambar.getResourceId(i, -1), dataDescription[i], dataTanggal[i])
            listChat.add(chat)
        }
        return listChat
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvChat.layoutManager =
                GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvChat.layoutManager =
                LinearLayoutManager(requireContext())
        }
    val listChatAdapter = ListChatAdapter(dataChat)
        binding.rvChat.adapter = listChatAdapter
        listChatAdapter.setOnItemClickCallback(object :
            ListChatAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Chat) {
                showSelectedChat(data)
            }
        })
    }

    private fun showSelectedChat(chat: Chat) {
        val intentWithData = Intent(requireContext(), DetailChatActivity::class.java)
        intentWithData.putExtra(DetailChatActivity.EXTRA_CHAT, chat)
        startActivity(intentWithData)
    }
}
