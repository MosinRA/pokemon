package com.mosin.mvp_kotlin.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.mosin.mvp_kotlin.mvp.model.entity.GitHubUser
import com.mosin.mvp_kotlin.mvp.navigation.IScreens
import com.mosin.mvp_kotlin.ui.fragment.UserInfoFragment
import com.mosin.mvp_kotlin.ui.fragment.UsersFragment

class AndroidScreenInfo : IScreens {
    override fun users() = FragmentScreen { UserInfoFragment.newInstance() }
}