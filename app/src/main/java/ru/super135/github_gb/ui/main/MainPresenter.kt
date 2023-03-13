package ru.super135.github_gb.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.super135.github_gb.IScreens


class MainPresenter(private val router: Router, private val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}
