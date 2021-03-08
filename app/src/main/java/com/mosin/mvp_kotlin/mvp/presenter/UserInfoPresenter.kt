package com.mosin.mvp_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.mosin.mvp_kotlin.mvp.model.GitHubUsersRepo
import com.mosin.mvp_kotlin.mvp.view.UserInfoView
import moxy.MvpPresenter

class UserInfoPresenter(val usersRepo: GitHubUsersRepo, val router: Router) :
    MvpPresenter<UserInfoView>() {

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}