package ru.super135.github_gb.ui.profile

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.super135.github_gb.domain.GitHubUser
import ru.super135.github_gb.ui.common.ProgressView

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView, ProgressView {
    fun setUser(user: GitHubUser)
}