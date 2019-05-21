package com.farahani.elmira.presentation.details.comments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farahani.elmira.presentation.R
import com.farahani.elmira.presentation.details.comments.CommentsListAction
import com.farahani.elmira.presentation.models.CommentModel
import io.reactivex.subjects.PublishSubject

class CommentsRecyclerAdapter : RecyclerView.Adapter<CommentsRecyclerAdapter.CommentViewHolder>() {

    val listActionSubject = PublishSubject.create<CommentsListAction>()

    val items = mutableListOf<CommentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_item_layout, parent, false)

        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        holder.titleTextView.text = items[position].body
        holder.nameTextView.text = items[position].name
        holder.mailTextView.text = items[position].email

        holder.titleTextView.setOnClickListener {
            listActionSubject.onNext(CommentsListAction.CommentClicked(items[position].id))
        }
    }

    fun submitList(list: List<CommentModel>) {
        items.clear()
        items.addAll(list)
    }

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.commentBodyTextView)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val mailTextView: TextView = view.findViewById(R.id.mailTextView)
    }
}