package com.farahani.elmira.presentation

import com.farahani.elmira.presentation.models.PostModel

sealed class PostsListAction {

    class PostsListItemAction(val postModel: PostModel) : PostsListAction()

    class LoadMorePostsAction : PostsListAction()
}