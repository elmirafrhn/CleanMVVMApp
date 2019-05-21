package com.farahani.elmira.presentation.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.farahani.elmira.presentation.adapter.BaseAction
import io.reactivex.subjects.PublishSubject

class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val subject=PublishSubject.create<BaseAction>()
}