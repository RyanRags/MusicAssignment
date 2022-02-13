package com.example.musicassignment.view

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicassignment.databinding.FragmentPopBinding
import com.example.musicassignment.model.common.TERM
import com.example.musicassignment.model.common.musicTypesData
import com.example.musicassignment.model.rock.SongResponse
import com.example.musicassignment.model.rock.Songs
import com.example.musicassignment.viewmodel.IPresenterMusic
import com.example.musicassignment.viewmodel.PresenterMusic
import com.example.musicassignment.viewmodel.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

private const val TAG = "MusicFragment"
class MusicFragment: Fragment(), MusicView {

    private val presenter: PresenterMusic by lazy {
        PresenterMusic()
    }
    private var position = 0
    private lateinit var binding: FragmentPopBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPopBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView: $position")
        presenter.bind(this)
        requestData()
        Log.d(TAG, "onCreateView:3 $position")
        return binding.root
    }

    fun swipeFrag(i: Int){
        position = i
    }

    override fun requestData() {
        presenter.getSongInfo(musicTypesData[position])
    }

    override fun displayData(songs: SongResponse) {
        initViews(songs)
    }

    override fun initViews(data: SongResponse) {
        binding.fragPop.layoutManager = GridLayoutManager(context, 1)
        binding.fragPop.adapter = ViewPagerAdapter(data.results.map {
            Songs(
                it.artistName,
                it.collectionName,
                it.artworkUrl60,
                it.trackPrice,
                it.previewUrl
            )
        }){
            MediaPlayer.create(requireContext(),Uri.parse(it.previewUrl)).start()
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unbind()
    }

}