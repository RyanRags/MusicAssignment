package com.example.musicassignment.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicassignment.databinding.ItemLayoutBinding
import com.example.musicassignment.model.rock.Songs
import com.example.musicassignment.view.MusicViewHolder

class ViewPagerAdapter(private val dataSet: List<Songs>, private val openDisplayFrag: (Songs) -> Unit):
    RecyclerView.Adapter<MusicViewHolder>() {

    override fun getItemCount(): Int = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MusicViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(dataSet[position]) {
            openDisplayFrag(it)
        }
    }
}