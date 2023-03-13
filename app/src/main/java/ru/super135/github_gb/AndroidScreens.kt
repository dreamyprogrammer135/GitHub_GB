package ru.super135.github_gb

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.super135.github_gb.ui.profile.ProfileFragment
import ru.super135.github_gb.ui.users.UsersFragment


class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun profile(login: String) = FragmentScreen { ProfileFragment.newInstance(login) }
}

interface IScreens {
    fun users(): Screen
    fun profile(login: String): Screen
}