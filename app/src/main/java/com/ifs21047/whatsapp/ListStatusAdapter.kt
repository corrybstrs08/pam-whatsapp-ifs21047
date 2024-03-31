package com.ifs21047.whatsapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21047.whatsapp.databinding.ItemRowStatusBinding

class ListStatusAdapter(private val listStatus: ArrayList<Status>) :
    RecyclerView.Adapter<ListStatusAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback:
                               OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:
    Int): ListViewHolder {
        val binding =
            ItemRowStatusBinding.inflate(LayoutInflater.from(viewGroup.context),
                viewGroup, false)
        return ListViewHolder(binding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position:
    Int) {
        val status = listStatus[position]
        holder.binding.imageGambar.setImageResource(status.gambar)
        holder.binding.tvNama.text = status.nama
        holder.binding.tvJam.text=status.jam
        holder.itemView.setOnClickListener {
            onItemClickCallback
                .onItemClicked(listStatus[holder.adapterPosition])
        }
    }
    override fun getItemCount(): Int = listStatus.size
    class ListViewHolder(var binding: ItemRowStatusBinding) :
        RecyclerView.ViewHolder(binding.root)
    interface OnItemClickCallback {
        fun onItemClicked(data: Status)
    }
}