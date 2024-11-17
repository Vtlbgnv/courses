package com.example.courses.network.di

import com.example.courses.network.provideMoshi
import org.koin.dsl.module

val moshiModule = module {
	single { provideMoshi() }
}