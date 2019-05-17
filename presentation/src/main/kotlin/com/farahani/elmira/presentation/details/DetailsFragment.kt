package com.farahani.elmira.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farahani.elmira.presentation.R
import com.farahani.elmira.presentation.models.PostModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater?.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<PostModel>("post")?.let {
            titleTextView.text = it.title
            bodyTextView.text = it.body
        }
    }

    companion object {

        fun newInstance(post: PostModel): DaggerFragment =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("post", post)
                }
            }
    }
}