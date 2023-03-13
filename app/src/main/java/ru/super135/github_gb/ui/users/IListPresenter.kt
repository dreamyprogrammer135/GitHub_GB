package ru.super135.github_gb.ui.users

interface ListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface UserListPresenter : ListPresenter<UserItemView>
