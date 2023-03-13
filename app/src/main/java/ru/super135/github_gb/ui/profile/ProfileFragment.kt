package ru.super135.github_gb.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.super135.github_gb.App
import ru.super135.github_gb.R
import ru.super135.github_gb.databinding.FragmentProfileBinding
import ru.super135.github_gb.domain.GitHubUser
import ru.super135.github_gb.ui.common.BackButtonListener

const val ARG_USER = "ARG_USER_LOGIN"

class ProfileFragment : MvpAppCompatFragment(), ProfileView, BackButtonListener {

    companion object {
        fun newInstance(login: String) =
            ProfileFragment().apply { arguments = bundleOf(ARG_USER to login) }
    }

    private val login: String? by lazy {
        arguments?.getString(ARG_USER, "login 1")
    }
    private val binding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)
    private val presenter: ProfilePresenter by moxyPresenter {
        ProfilePresenter(
            login,
            App.instance.usersRepo,
            App.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun backPressed() = presenter.backPressed()

    override fun setUser(user: GitHubUser) {
        binding.tvLogin.text = user.login
    }

    override fun showProgressBar() {
        binding.loadingLayout.progressBar.isVisible = true
    }

    override fun hideProgressBar() {
        binding.loadingLayout.progressBar.isVisible = false
    }

}