package com.example.courses.core.navigation.router

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen

class FullScreenRouter(private val router: Router) {

	private val _backStack = mutableListOf<Screen>()
	val backStack: List<Screen>
		get() = _backStack.toList()

	fun navigateTo(screen: Screen) {
		router.navigateTo(screen)

		_backStack.add(screen)
	}

	fun newRootScreen(screen: Screen) {
		router.newRootScreen(screen)

		_backStack.clear()
		_backStack.add(screen)
	}

	fun navigateBack() {
		router.exit()

		_backStack.removeLastOrNull()
	}

	fun finishChain() {
		router.finishChain()

		_backStack.clear()
	}

	fun replace(screen: Screen) {
		router.replaceScreen(screen)

		_backStack.removeLastOrNull()
		_backStack.add(screen)
	}
}