package com.example.courses

import android.app.Application
import com.example.courses.core.network.di.networkModule
import com.example.courses.features.main.courses.di.coursesModule
import com.example.courses.features.main.details.di.detailsModule
import com.example.courses.features.mainhost.di.mainHostModule
import com.example.courses.features.userfavorites.di.UserFavoritesModule
import com.example.courses.navigation.di.ciceroneModule
import com.example.courses.navigation.di.mainModule
import com.example.courses.navigation.di.routersModule
import com.example.courses.network.di.moshiModule
import com.example.courses.shared.favorite.di.favoriteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)

			modules(mainHostModule)
			modules(ciceroneModule)
			modules(mainModule)
			modules(routersModule)
			modules(networkModule)
			modules(moshiModule)
			modules(coursesModule)
			modules(detailsModule)
			modules(favoriteModule)
			modules(UserFavoritesModule)
		}
	}
}