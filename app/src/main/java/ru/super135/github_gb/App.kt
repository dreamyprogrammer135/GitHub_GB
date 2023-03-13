package ru.super135.github_gb

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.super135.github_gb.data.GitHubUsersRepo

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router


    val usersRepo = GitHubUsersRepo()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}