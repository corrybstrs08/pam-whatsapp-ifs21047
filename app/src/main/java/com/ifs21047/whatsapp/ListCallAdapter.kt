package com.ifs21047.whatsapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21047.whatsapp.databinding.ItemRowCallBinding

class ListCallAdapter(private val listCall: ArrayList<Call>) :
    RecyclerView.Adapter<ListCallAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback:
                               OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:
    Int): ListViewHolder {
        val binding =
            ItemRowCallBinding.inflate(LayoutInflater.from(viewGroup.context),
                viewGroup, false)
        return ListViewHolder(binding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val call = listCall[position]
        holder.binding.imgGambar.setImageResource(call.gambar)
        holder.binding.tvNama.text = call.nama
        holder.binding.tvPesan.text = call.waktu
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listCall[holder.adapterPosition])
        }
    }
    override fun getItemCount(): Int = listCall.size
    class ListViewHolder(var binding: ItemRowCallBinding) :
        RecyclerView.ViewHolder(binding.root)
    interface OnItemClickCallback {
        fun onItemClicked(data: Call)
    }
}