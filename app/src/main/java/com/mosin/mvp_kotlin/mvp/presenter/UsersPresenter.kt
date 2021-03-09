package com.mosin.mvp_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.mosin.mvp_kotlin.mvp.model.GitHubUsersRepo
import com.mosin.mvp_kotlin.mvp.model.entity.GitHubUser
import com.mosin.mvp_kotlin.mvp.presenter.list.IUserListPresenter
import com.mosin.mvp_kotlin.mvp.view.UsersView
import com.mosin.mvp_kotlin.mvp.view.list.IUserItemView
import com.mosin.mvp_kotlin.ui.navigation.AndroidScreenInfo
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GitHubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { view ->
            val user = usersListPresenter.users[view.pos]
            router.navigateTo(AndroidScreenInfo(usersListPresenter.users[view.pos]).users())
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.clear()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}