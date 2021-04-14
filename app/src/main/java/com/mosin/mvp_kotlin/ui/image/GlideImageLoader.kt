package com.mosin.mvp_kotlin.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mosin.mvp_kotlin.mvp.model.image.IImageLoader
import com.mosin.mvp_kotlin.mvp.model.network.INetworkStatus
import com.mosin.mvp_kotlin.mvp.model.repo.IImageCache

class GlideImageLoader(val imageCache: IImageCache, val networkStatus: INetworkStatus) :
    IImageLoader<ImageView> {
    override fun load(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .circleCrop()
            .into(container)
    }
}