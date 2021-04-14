package com.mosin.mvp_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.mosin.mvp_kotlin.databinding.FragmentPokemonInfoBinding
import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import com.mosin.mvp_kotlin.mvp.model.image.IImageLoader
import com.mosin.mvp_kotlin.mvp.presenter.InfoForPokemonPresenter
import com.mosin.mvp_kotlin.mvp.view.PokeInfoView
import com.mosin.mvp_kotlin.ui.App
import com.mosin.mvp_kotlin.ui.IBackClickListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class InfoForPokemonFragment() : MvpAppCompatFragment(),
    PokeInfoView, IBackClickListener {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    companion object {
        private const val USER_ARG = "user"
        fun newInstance(user: AllPokemon) = InfoForPokemonFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
            }
        }
    }

    private var ui: FragmentPokemonInfoBinding? = null

    private val presenter by moxyPresenter {
        val user = arguments?.getParcelable<AllPokemon>(USER_ARG) as AllPokemon
        InfoForPokemonPresenter(user).apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentPokemonInfoBinding.inflate(inflater, container, false).also {
            ui = it
            App.instance.appComponent.inject(this)
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun backPressed(): Boolean = presenter.backClick()

    override fun init() {

    }

    override fun setLogin(text: String) {
        ui?.userLogin?.text = text
    }

    override fun setImage(url: String) {
        ui?.ivAvatar?.let { imageLoader.load(url, it) }

    }

    override fun setInfoForPokemon(
        hp: Int,
        attack: Int,
        defense: Int,
        speed: Int,
        height: String,
        weight: String,
        description: String
    ) {
        ui?.hpText?.text = hp.toString()
        ui?.attackText?.text = attack.toString()
        ui?.defenseText?.text = defense.toString()
        ui?.speedText?.text = speed.toString()
        ui?.heightText?.text = height
        ui?.weightText?.text = weight
        ui?.description?.text = description
        ui?.progressBarHP?.progress = hp
        ui?.progressBarAttack?.progress = attack
        ui?.progressBarDefense?.progress = defense
        ui?.progressBarSpeed?.progress = speed
    }
}


