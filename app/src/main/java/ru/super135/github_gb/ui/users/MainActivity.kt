package ru.super135.github_gb.ui.users

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.super135.github_gb.data.GitHubUsersRepo
import ru.super135.github_gb.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainView {
    private val presenter by moxyPresenter { MainPresenter(GitHubUsersRepo()) }
    private var adapter: UsersAdapter? = null
    private var vb: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(this)
        adapter = UsersAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}
