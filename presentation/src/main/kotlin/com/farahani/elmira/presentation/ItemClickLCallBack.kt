package com.farahani.elmira.presentation

import com.farahani.elmira.presentation.models.PostModel

interface ItemClickLCallBack {

    fun onItemClick(postModel: PostModel)
}