package com.farahani.elmira.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.farahani.elmira.presentation.models.PostModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class PostsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val adapter: PostsRecyclerViewAdapter by lazy {
        PostsRecyclerViewAdapter()
    }

    var itemClickLCallBack: ItemClickLCallBack? = null

    private val viewModel: PostsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(PostsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceStat: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.postsState.observe(this,
            Observer {
                if (it != null) handleProgressBarVisibility(it)
            }
        )

        viewModel.showDetailFragmet.observe(this,
            Observer {
                itemClickLCallBack?.onItemClick(it)
            })

        viewModel.posts.observe(this,
            Observer<List<PostModel>> {
                val diffUtil = DiffUtil.calculateDiff(
                    CustomDiffUtil(
                        adapter.items, it
                    )
                )
                diffUtil.dispatchUpdatesTo(adapter)

                adapter.submitList(it)
                postsRecyclerView.layoutManager = LinearLayoutManager(activity)
                postsRecyclerView.adapter = adapter
            })
        postsRecyclerView.addDividerLine()

        viewModel.loadMoreSubject = adapter.listActionSubject
        viewModel.handlePostsListActions()
    }

    private fun handleProgressBarVisibility(getPostsViewStates: GetPostsViewStates) {
        progressBar.visibility = if (getPostsViewStates.showLoading) View.VISIBLE else View.GONE
        if (getPostsViewStates.error) Toast.makeText(activity, "error happend!", Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(itemClickLCallBack: ItemClickLCallBack): PostsFragment = PostsFragment().apply {
            this.itemClickLCallBack = itemClickLCallBack
        }
    }

}