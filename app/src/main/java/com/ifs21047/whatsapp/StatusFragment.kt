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
import com.ifs21047.whatsapp.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {
    private lateinit var binding: FragmentStatusBinding
    private val dataStatus = ArrayList<Status>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvStatus.setHasFixedSize(false)
        dataStatus.addAll(getListStatus())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListStatus(): ArrayList<Status> {
        val dataNama =
            resources.getStringArray(R.array.nama)
        val dataGambar =
            resources.obtainTypedArray(R.array.user_status)
        val dataJam =
            resources.getStringArray(R.array.jam)
        val listStatus = ArrayList<Status>()
        for (i in dataNama.indices) {
            val status = Status(dataNama[i],
                dataGambar.getResourceId(i, -1), dataJam[i])
            listStatus.add(status)
        }
        return listStatus
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvStatus.layoutManager =
                GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvStatus.layoutManager =
                LinearLayoutManager(requireContext())
        }
        val listStatusAdapter = ListStatusAdapter(dataStatus)
        binding.rvStatus.adapter = listStatusAdapter
        listStatusAdapter.setOnItemClickCallback(object :
            ListStatusAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Status) {
                showSelectedStatus(data)
            }
        })
    }

    private fun showSelectedStatus(status: Status) {
        val intentWithData = Intent(requireContext(), MainActivity::class.java)
        intentWithData.putExtra(MainActivity.EXTRA_STATUS, status)
        startActivity(intentWithData)
    }
}
