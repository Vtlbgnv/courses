package com.example.courses.core.network.provider

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

private const val VALUE_TIMEOUT: Long = 60

fun provideOkHttpClient(
	interceptors: List<Interceptor> = emptyList(),
	authenticator: Authenticator? = null,
): OkHttpClient =
	OkHttpClient()
		.newBuilder()
		.applyDefaultSetups(interceptors, authenticator)
		.build()

private fun OkHttpClient.Builder.applyDefaultSetups(
	interceptors: List<Interceptor>,
	authenticator: Authenticator?,
): OkHttpClient.Builder {
	connectTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS)
	writeTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS)
	readTimeout(VALUE_TIMEOUT, TimeUnit.SECONDS)
	retryOnConnectionFailure(true)

	interceptors.forEach { addInterceptor(it) }
	if (authenticator != null) {
		authenticator(authenticator)
	}
	return this
}