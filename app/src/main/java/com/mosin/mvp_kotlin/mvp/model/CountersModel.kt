package com.mosin.mvp_kotlin.mvp.model

class CountersModel {

    val counters = mutableListOf(0, 0, 0)

    fun getCount(index: Int) = counters[index]

    fun nextIndex
}