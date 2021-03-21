package com.mosin.mvp_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.mosin.mvp_kotlin.mvp.model.entity.GitHubRepo
import com.mosin.mvp_kotlin.mvp.model.entity.GitHubUser
import com.mosin.mvp_kotlin.mvp.model.repo.IGitHubUserRepos
import com.mosin.mvp_kotlin.mvp.presenter.list.IUserRepoListPresenter
import com.mosin.mvp_kotlin.mvp.view.UserInfoView
import com.mosin.mvp_kotlin.mvp.view.list.IUserReposItemView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UserInfoPresenter(
    val uiScheduler: Scheduler,
    val router: Router,
    val user: GitHubUser,
    val repos: IGitHubUserRepos
) :
    MvpPresenter<UserInfoView>() {

    class UserReposListPresenter : IUserRepoListPresenter {

        val repos = mutableListOf<GitHubRepo>()
        override var itemClickListener: ((IUserReposItemView) -> Unit)? = null

        override fun bindView(view: IUserReposItemView) {
            val repos = repos[view.pos]
            view.setNameRepos(repos.name)
        }

        override fun getCount() = repos.size
    }

    val userReposListPresenter = UserReposListPresenter()
    val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setLogin(user.login)
        viewState.setImage(user.avatarUrl)
        loadRepos()
//
//        userReposListPresenter.itemClickListener = { view ->
//            val user = userReposListPresenter.repos[view.pos]
//        }
    }

    private fun loadRepos() {
        val disposable = repos.getRepos(user)
            .observeOn(uiScheduler)
            .subscribe({ reposList ->
                userReposListPresenter.repos.addAll(reposList)
                viewState.updateReposList()
            }, { error ->
                error.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}