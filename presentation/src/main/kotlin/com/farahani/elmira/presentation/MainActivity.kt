package com.farahani.elmira.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.farahani.elmira.presentation.details.DetailsFragment
import com.farahani.elmira.presentation.models.PostModel
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), ItemClickLCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, PostsFragment.newInstance(this))
            .addToBackStack("post_fragment")
            .commit()
    }

    override fun onItemClick(postModel: PostModel) {
        FragmentManager.enableDebugLogging(true)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DetailsFragment.newInstance(postModel))
            .addToBackStack("details_fragment").commit()
    }
}