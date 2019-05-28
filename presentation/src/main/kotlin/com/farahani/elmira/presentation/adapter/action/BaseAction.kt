package com.farahani.elmira.presentation.adapter.action

import com.farahani.elmira.presentation.adapter.action.ActionType

interface BaseAction {
    fun getType(): ActionType
}