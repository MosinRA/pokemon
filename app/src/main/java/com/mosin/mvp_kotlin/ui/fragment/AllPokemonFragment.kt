package com.mosin.mvp_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mosin.mvp_kotlin.databinding.FragmentAllPokemonBinding
import com.mosin.mvp_kotlin.mvp.presenter.AllPokemonPresenter
import com.mosin.mvp_kotlin.mvp.view.StartAllPokemonView
import com.mosin.mvp_kotlin.ui.App
import com.mosin.mvp_kotlin.ui.IBackClickListener
import com.mosin.mvp_kotlin.ui.adapter.StartPokemonAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AllPokemonFragment : MvpAppCompatFragment(), StartAllPokemonView, IBackClickListener {
    private var ui: FragmentAllPokemonBinding? = null
    private val adapter by lazy {
        StartPokemonAdapter(presenter.usersListPresenter).apply {
            App.instance.appComponent.inject(this)
        }
    }

    companion object {
        fun newInstance() = AllPokemonFragment()
    }

    private val presenter by moxyPresenter {
        AllPokemonPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAllPokemonBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        ui?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        ui?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()
}