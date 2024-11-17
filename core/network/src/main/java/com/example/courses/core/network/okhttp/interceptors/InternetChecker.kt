package com.example.courses.core.network.okhttp.interceptors

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class InternetChecker(context: Context) {

	private val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

	val connected: Boolean
		get() = postAndroidMInternetCheck()

	@SuppressLint("MissingPermission")
	private fun postAndroidMInternetCheck(): Boolean =
		cm.getNetworkCapabilities(cm.activeNetwork)?.let {
			it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
		} ?: false


}