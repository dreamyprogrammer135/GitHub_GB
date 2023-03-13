package ru.super135.github_gb.ui.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.super135.github_gb.data.GitHubUsersRepo
import ru.super135.github_gb.domain.GitHubUser

class UsersPresenter(val usersRepo: GitHubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {
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
//TODO: переход на экран пользователя c помощью router.navigateTo
        }
    }
    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
