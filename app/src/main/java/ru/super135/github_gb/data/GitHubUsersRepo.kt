package ru.super135.github_gb.data

import ru.super135.github_gb.domain.GitHubUser

class GitHubUsersRepo {
    private val repositories = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5")
    )
    fun getUsers() : List<GitHubUser> {
        return repositories
    }
}
