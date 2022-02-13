package com.example.musicassignment.view

import androidx.recyclerview.widget.RecyclerView
import com.example.musicassignment.R
import com.example.musicassignment.databinding.ItemLayoutBinding
import com.example.musicassignment.model.rock.Songs
import com.squareup.picasso.Picasso

class MusicViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(volumeItem: Songs, callback: (Songs) -> Unit){

        binding.tvArtist.text = binding.root.context
            .getString(R.string.Artist, volumeItem.artistName.toString())
        binding.tvSong.text = binding.root.context
            .getString(R.string.Song, volumeItem.collectionName.toString())
        binding.tvPrice.text = binding.root.context
            .getString(R.string.Price, volumeItem.trackPrice.toString())

        Picasso.get().load(volumeItem.artworkUrl60)
            .into(binding.ivSongAlbumCover)

        binding.root.setOnClickListener {
            callback(volumeItem)
        }
    }
}