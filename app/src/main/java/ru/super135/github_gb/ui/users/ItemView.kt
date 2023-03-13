package ru.super135.github_gb.ui.users

interface IItemView {
    var pos: Int
}
interface UserItemView: IItemView {
    fun setLogin(text: String)
}