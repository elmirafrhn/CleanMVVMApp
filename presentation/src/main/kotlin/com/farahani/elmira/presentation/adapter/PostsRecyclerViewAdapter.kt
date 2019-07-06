package com.farahani.elmira.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farahani.elmira.presentation.R
import com.farahani.elmira.presentation.adapter.action.PostsListAction
import com.farahani.elmira.presentation.models.PostModel
import io.reactivex.subjects.PublishSubject

class PostsRecyclerViewAdapter : RecyclerView.Adapter<PostsRecyclerViewAdapter.PostViewHolder>() {

    val listActionSubject = PublishSubject.create<PostsListAction>()

    val items = mutableListOf<PostModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item_layout, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.titleTextView.text = items[position].title

        holder.titleTextView.setOnClickListener {
            listActionSubject.onNext(PostsListAction.PostsListItemAction(items[position]))
        }

        if (position >= items.size - 1) {
            listActionSubject.onNext(PostsListAction.LoadMorePostsAction())
        }
    }

    fun submitList(postList: List<PostModel>) {
        items.addAll(postList)
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.postTitleTextView)
    }
}