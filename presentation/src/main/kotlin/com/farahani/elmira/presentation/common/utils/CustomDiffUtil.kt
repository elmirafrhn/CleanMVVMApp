package com.farahani.elmira.presentation.common.utils

import androidx.recyclerview.widget.DiffUtil
import com.farahani.elmira.presentation.models.PostModel

class CustomDiffUtil(var oldList: List<PostModel>, var newList: List<PostModel>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].equals(newList[newItemPosition])
}