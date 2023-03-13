package ru.super135.github_gb.ui.users

import moxy.MvpPresenter
import ru.super135.github_gb.data.GitHubUsersRepo
import ru.super135.github_gb.domain.GitHubUser

class MainPresenter(val usersRepo: GitHubUsersRepo): MvpPresenter<MainView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
    val usersListPresenter = UsersListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
//TODO: переход на экран пользователя
        }
    }
    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}
