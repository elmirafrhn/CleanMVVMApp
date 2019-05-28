package com.farahani.elmira.presentation.interfaces

import com.farahani.elmira.presentation.models.PostModel

interface ItemClickLCallBack {

    fun onItemClick(postModel: PostModel)
}