package com.farahani.elmira.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.farahani.elmira.presentation.R
import com.farahani.elmira.presentation.addDividerLine
import com.farahani.elmira.presentation.details.comments.CommentsViewModel
import com.farahani.elmira.presentation.details.comments.adapter.CommentsRecyclerAdapter
import com.farahani.elmira.presentation.models.CommentModel
import com.farahani.elmira.presentation.models.PostModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CommentsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(CommentsViewModel::class.java)
    }

    private val adapter by lazy {
        CommentsRecyclerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<PostModel>("post")?.let {

            viewModel.setPostId(it)

            viewModel.comments?.observe(this,
                Observer<List<CommentModel>> { comments ->

                    adapter.submitList(comments)
                    commentsRecyclerView.layoutManager = LinearLayoutManager(activity)
                    commentsRecyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            )

            commentsRecyclerView.addDividerLine()


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