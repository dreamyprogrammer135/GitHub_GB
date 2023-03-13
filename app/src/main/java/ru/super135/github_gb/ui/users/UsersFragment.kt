package ru.super135.github_gb.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.super135.github_gb.App
import ru.super135.github_gb.data.GitHubUsersRepo
import ru.super135.github_gb.databinding.FragmentUsersBinding
import ru.super135.github_gb.ui.common.BackButtonListener

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GitHubUsersRepo(),
            App.instance.router
        )
    }
    private var adapter: UsersAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showProgressBar() {
        vb?.loadingLayout?.progressBar?.isVisible = true
    }

    override fun hideProgressBar() {
        vb?.loadingLayout?.progressBar?.isVisible = false
    }

    override fun backPressed() = presenter.backPressed()
}