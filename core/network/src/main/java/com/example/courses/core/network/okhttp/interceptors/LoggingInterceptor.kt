package com.example.courses.core.network.okhttp.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptor : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response =
		HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY).intercept(chain)
}