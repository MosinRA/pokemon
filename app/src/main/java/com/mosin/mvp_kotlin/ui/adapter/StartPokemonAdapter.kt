package com.mosin.mvp_kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mosin.mvp_kotlin.databinding.ItemUserBinding
import com.mosin.mvp_kotlin.mvp.model.image.IImageLoader
import com.mosin.mvp_kotlin.mvp.presenter.list.IAllPokemonListPresenter
import com.mosin.mvp_kotlin.mvp.view.list.IUserItemView
import javax.inject.Inject

class StartPokemonAdapter(val presenter: IAllPokemonListPresenter) :
    RecyclerView.Adapter<StartPokemonAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ).apply {
        itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
    }

    override fun getItemCount(): Int = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root),
        IUserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }

        override fun loadAvatar(url: String) = with(vb) {
            imageLoader.load(url, ivAvatar)
        }
    }
}