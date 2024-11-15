package com.example.courses.navigation.di

import com.example.courses.core.navigation.buildCicerone
import com.example.courses.core.navigation.utils.RouterNames.FAVORITES_SECTION
import com.example.courses.core.navigation.utils.RouterNames.FULL_SCREEN
import com.example.courses.core.navigation.utils.RouterNames.MAIN_HOST
import com.example.courses.core.navigation.utils.RouterNames.MAIN_SECTION
import com.example.courses.core.navigation.utils.RouterNames.PROFILE_SECTION
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.core.qualifier.named
import org.koin.dsl.module

val ciceroneModule = module {
	single(named(FULL_SCREEN)) { buildCicerone() }
	single(named(FULL_SCREEN)) { get<Cicerone<Router>>(named(FULL_SCREEN)).router }
	single(named(FULL_SCREEN)) { get<Cicerone<Router>>(named(FULL_SCREEN)).getNavigatorHolder() }

	single(named(MAIN_HOST)) { buildCicerone() }
	single(named(MAIN_HOST)) { get<Cicerone<Router>>(named(MAIN_HOST)).router }
	single(named(MAIN_HOST)) { get<Cicerone<Router>>(named(MAIN_HOST)).getNavigatorHolder() }

	single(named(MAIN_SECTION)) { buildCicerone() }
	single(named(MAIN_SECTION)) { get<Cicerone<Router>>(named(MAIN_SECTION)).router }
	single(named(MAIN_SECTION)) { get<Cicerone<Router>>(named(MAIN_SECTION)).getNavigatorHolder() }

	single(named(FAVORITES_SECTION)) { buildCicerone() }
	single(named(FAVORITES_SECTION)) { get<Cicerone<Router>>(named(FAVORITES_SECTION)).router }
	single(named(FAVORITES_SECTION)) { get<Cicerone<Router>>(named(FAVORITES_SECTION)).getNavigatorHolder() }

	single(named(PROFILE_SECTION)) { buildCicerone() }
	single(named(PROFILE_SECTION)) { get<Cicerone<Router>>(named(PROFILE_SECTION)).router }
	single(named(PROFILE_SECTION)) { get<Cicerone<Router>>(named(PROFILE_SECTION)).getNavigatorHolder() }
}
