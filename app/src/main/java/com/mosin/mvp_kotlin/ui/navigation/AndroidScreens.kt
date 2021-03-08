package com.mosin.mvp_kotlin.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.mosin.mvp_kotlin.mvp.navigation.IScreens
import com.mosin.mvp_kotlin.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}