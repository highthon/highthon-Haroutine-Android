package com.example.haroutine_android.ui.seokgyu.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.haroutine_android.R
import com.example.haroutine_android.databinding.ItemRoutineBinding
import com.example.haroutine_android.dto.response.seokgyu.GetRoutineResponse

class RoutineAdapter(
    private val itemClick: (GetRoutineResponse) -> Unit)
    : ListAdapter<GetRoutineResponse, RoutineAdapter.CommentViewHolder>(CommentDiffUtilCallback) {

    inner class CommentViewHolder(private val binding: ItemRoutineBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GetRoutineResponse) {
            binding.item = item
            binding.tvTime.text =
                "${item.writer} ${item.startTime} - ${item.lastTime}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_routine,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object CommentDiffUtilCallback : DiffUtil.ItemCallback<GetRoutineResponse>() {
        override fun areItemsTheSame(oldItem: GetRoutineResponse, newItem: GetRoutineResponse): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: GetRoutineResponse, newItem: GetRoutineResponse): Boolean = oldItem == newItem
    }
}