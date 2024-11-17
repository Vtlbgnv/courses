package com.example.courses.core.network.okhttp.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NoConnectivityException : IOException()

class NoConnectionInterceptor(
	private val internetChecker: InternetChecker,
) : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		if (!internetChecker.connected) {
			throw NoConnectivityException()
		}

		return chain.proceed(chain.request())
	}
}
