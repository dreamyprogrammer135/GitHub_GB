package ru.super135.github_gb.ui.profile

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.super135.github_gb.data.GitHubUsersRepo

class ProfilePresenter(
    private val login: String?,
    private val usersRepo: GitHubUsersRepo,
    private val router: Router
) : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProgressBar()
        setUser()
    }

    private fun setUser() {
        login?.let {
            viewState.setUser(usersRepo.getUser(login))
            viewState.hideProgressBar()
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}