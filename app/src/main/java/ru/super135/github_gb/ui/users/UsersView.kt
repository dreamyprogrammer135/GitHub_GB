package ru.super135.github_gb.ui.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.super135.github_gb.ui.common.ProgressView

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : MvpView, ProgressView {
    fun init()
    fun updateList()
}
