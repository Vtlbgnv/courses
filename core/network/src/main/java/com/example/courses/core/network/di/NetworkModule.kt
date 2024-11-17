package com.example.courses.core.network.di

import com.example.courses.core.network.okhttp.interceptors.InternetChecker
import com.example.courses.core.network.okhttp.interceptors.LoggingInterceptor
import com.example.courses.core.network.okhttp.interceptors.NoConnectionInterceptor
import com.example.courses.core.network.provider.provideOkHttpClient
import com.example.courses.core.network.provider.provideRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val LOG_INTERCEPTOR = "LOGGING_INTERCEPTOR"
const val NO_CONNECT_INTERCEPTOR = "NO_CONNECTION_INTERCEPTOR"
const val BASE_URL = "https://stepik.org"

val networkModule = module {
	single(named(LOG_INTERCEPTOR)) { LoggingInterceptor() }
	single(named(NO_CONNECT_INTERCEPTOR)) {
		NoConnectionInterceptor(
			internetChecker = InternetChecker(
				context = androidContext(),
			),
		)
	}

	single {
		provideOkHttpClient(
			interceptors = listOf(
				get<NoConnectionInterceptor>(named(NO_CONNECT_INTERCEPTOR)),
				get<LoggingInterceptor>(named(LOG_INTERCEPTOR)),
			)
		)
	}

	single {
		provideRetrofit(
			okHttpClient = get(),
			moshi = get(),
			url = BASE_URL
		)
	}
}