package com.farahani.elmira.presentation.adapter.action

import com.farahani.elmira.presentation.models.PostModel

sealed class PostsListAction {

    class PostsListItemAction(val postModel: PostModel) : PostsListAction()

    class LoadMorePostsAction : PostsListAction()
}