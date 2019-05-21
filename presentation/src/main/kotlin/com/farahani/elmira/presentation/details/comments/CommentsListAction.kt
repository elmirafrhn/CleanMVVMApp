package com.farahani.elmira.presentation.details.comments

sealed class CommentsListAction {

    class CommentClicked(id: Int) : CommentsListAction()
}