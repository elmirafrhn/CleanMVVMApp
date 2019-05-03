package com.farahani.elmira.presentation

import com.farahani.elmira.presentation.models.PostModel

data class GetPostsViewStates (

    var showLoading: Boolean = true,
    var postsList: List<PostModel>
)