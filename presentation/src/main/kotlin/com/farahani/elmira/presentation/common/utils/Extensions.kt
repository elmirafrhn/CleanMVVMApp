package com.farahani.elmira.presentation.common.utils

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.addDividerLine() {
    val dividerItemDecoration = DividerItemDecoration(
        this.context,
        LinearLayoutManager.VERTICAL
    )
    this.addItemDecoration(dividerItemDecoration)
}