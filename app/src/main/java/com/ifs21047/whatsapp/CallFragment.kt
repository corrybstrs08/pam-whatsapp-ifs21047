package com.ifs21047.whatsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21047.whatsapp.databinding.FragmentCallBinding

class CallFragment : Fragment() {
    private lateinit var binding: FragmentCallBinding
    private val dataCall = ArrayList<Call>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCall.setHasFixedSize(false)
        dataCall.addAll(getListCall())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListCall(): ArrayList<Call> {
        val dataNama = resources.getStringArray(R.array.nama)
        val dataGambar = resources.obtainTypedArray(R.array.gambar_profil)
        val dataPanggilan = resources.obtainTypedArray(R.array.gambar_panggilan)
        val dataPanah = resources.obtainTypedArray(R.array.gambar_panah)
        val dataWaktu = resources.getStringArray(R.array.waktu)
        val listCall = ArrayList<Call>()
        for (i in dataNama.indices) {
            val call = Call(
                dataNama[i],
                dataGambar.getResourceId(i, -1),
                dataPanggilan.getResourceId(i, -1),
                dataPanah.getResourceId(i, -1),
                dataWaktu[i]
            )
            listCall.add(call) // tambahkan objek call ke dalam listCall
        }
        return listCall
    }

    private fun showRecyclerList() {
        val layoutManager = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(requireContext(), 2)
        } else {
            LinearLayoutManager(requireContext())
        }
        binding.rvCall.layoutManager = layoutManager
        val listCallAdapter = ListCallAdapter(dataCall)
        binding.rvCall.adapter = listCallAdapter
        listCallAdapter.setOnItemClickCallback(object : ListCallAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Call) {
                showSelectedCall(data)
            }
        })
    }

    private fun showSelectedCall(call: Call) {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_CALL, call)
        startActivity(intent)
    }
}
