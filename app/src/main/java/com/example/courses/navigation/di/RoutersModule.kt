package com.example.courses.navigation.di

import com.example.courses.core.navigation.router.FullScreenRouter
import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.core.navigation.router.SectionRouter
import com.example.courses.core.navigation.utils.RouterNames.FAVORITES_SECTION
import com.example.courses.core.navigation.utils.RouterNames.FULL_SCREEN
import com.example.courses.core.navigation.utils.RouterNames.MAIN_HOST
import com.example.courses.core.navigation.utils.RouterNames.MAIN_SECTION
import com.example.courses.core.navigation.utils.RouterNames.PROFILE_SECTION
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.presentation.MainHostRouter
import com.example.courses.features.mainhost.presentation.section.NavSectionRouter
import com.example.courses.navigation.router.fullscreen.MainHostRouterImpl
import com.example.courses.navigation.router.global.GlobalRouterImpl
import com.example.courses.navigation.router.global.SectionsHostRouter
import com.example.courses.navigation.router.main.MainRouterImpl
import com.example.courses.navigation.router.sections.FavoritesNavSectionRouterImpl
import com.example.courses.navigation.router.sections.MainNavSectionRouterImpl
import com.example.courses.navigation.router.sections.ProfileNavSectionRouterImpl
import com.example.courses.presentation.MainRouter
import org.koin.core.qualifier.named
import org.koin.dsl.module

val fullScreenRouterModule = module {
	factory<MainHostRouter> { MainHostRouterImpl(router = get()) }

	single {
		SectionsHostRouter(
			mainHostRouter = get(named(MAIN_HOST)),
			sectionRouterMap = mapOf(
				SectionNames.MAIN_SECTION to get(named(MAIN_SECTION)),
				SectionNames.FAVORITES_SECTION to get(named(FAVORITES_SECTION)),
				SectionNames.PROFILE_SECTION to get(named(PROFILE_SECTION)),
			)
		)
	}
	single<GlobalRouter> {
		GlobalRouterImpl(
			fullScreenRouter = FullScreenRouter(get(named(FULL_SCREEN))),
			sectionsHostRouter = get(),
		)
	}
}

val sectionRouterModule = module {
	single<SectionRouter>(named(MAIN_SECTION)) { SectionRouter(get(named(MAIN_SECTION))) }
	single<SectionRouter>(named(FAVORITES_SECTION)) { SectionRouter(get(named(FAVORITES_SECTION))) }
	single<SectionRouter>(named(PROFILE_SECTION)) { SectionRouter(get(named(PROFILE_SECTION))) }

	factory<NavSectionRouter>(named(MAIN_SECTION)) { MainNavSectionRouterImpl(router = get(named(MAIN_SECTION))) }
	factory<NavSectionRouter>(named(FAVORITES_SECTION)) { FavoritesNavSectionRouterImpl(router = get(named(FAVORITES_SECTION))) }
	factory<NavSectionRouter>(named(PROFILE_SECTION)) { ProfileNavSectionRouterImpl(router = get(named(PROFILE_SECTION))) }
}

val mainRouter = module {
	factory<MainRouter> { MainRouterImpl(get()) }
}

val routersModule = listOf(
	fullScreenRouterModule,
	sectionRouterModule,
	mainRouter,
)