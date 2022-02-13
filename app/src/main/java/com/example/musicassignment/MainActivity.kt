package com.example.musicassignment

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.musicassignment.databinding.ActivityMainBinding
import com.example.musicassignment.model.common.Network
import com.example.musicassignment.model.common.TERM
import com.example.musicassignment.model.common.musicTypesData
import com.example.musicassignment.model.common.musicTypesUI
import com.example.musicassignment.view.MusicFragment
import com.example.musicassignment.viewmodel.PresenterMusic
import com.example.musicassignment.viewmodel.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
         val viewPager = findViewById<ViewPager2>(R.id.viewpager)

        val adapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = adapter
//        val pm = PresenterMusic().getSongInfo(musicTypesData[0])




        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
           tab.text =  musicTypesUI[position]
            when(position){
                0 -> {
                    //findViewById<ViewPager2>(R.id.viewpager).setBackgroundColor(resources.getColor(R.color.green))
                    tab.icon = getDrawable(R.drawable.ic_baseline_library_music_24)
                }
                1 -> {
                    //findViewById<ViewPager2>(R.id.viewpager).setBackgroundColor(resources.getColor(R.color.black))
                    tab.icon = getDrawable(R.drawable.ic_baseline_music_video_24)
                }
                2 -> {
                    //findViewById<ViewPager2>(R.id.viewpager).setBackgroundColor(resources.getColor(R.color.purple_200))
                    tab.icon = getDrawable(R.drawable.ic_baseline_queue_music_24)
                }
            }

        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            val frag = MusicFragment()
            //Network.songsApi.getSongInfo(TERM) // not returning the data
            frag.swipeFrag(position)
            Log.d(TAG, "createFragment: $position")
            return frag
        }
    }
}
