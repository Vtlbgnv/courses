package com.example.courses.core.navigation.navigator

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.courses.core.navigation.screenwrappers.ScreenWrapper
import com.example.courses.core.navigation.utils.AnimationType
import com.example.courses.core.navigation.utils.Animations
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreenNavigator(
	activity: FragmentActivity,
	containerId: Int,
	fragmentManager: FragmentManager = activity.supportFragmentManager,
) : AppNavigator(activity, containerId, fragmentManager) {

	override fun commitNewFragmentScreen(screen: FragmentScreen, addToBackStack: Boolean) {
		val transaction = fragmentManager.beginTransaction()
		transaction.setReorderingAllowed(true)

		val (enter, exit, popEnter, popExit) = getAnimation(screen)
		transaction.setCustomAnimations(
			enter,
			exit,
			popEnter,
			popExit,
		)

		val fragment =
			fragmentManager.findFragmentByTag(screen.screenKey) ?: screen.createFragment(fragmentFactory)

		if (screen.clearContainer) {
			transaction.replace(containerId, fragment, screen.screenKey)
		} else {
			transaction.add(containerId, fragment, screen.screenKey)
		}
		if (addToBackStack) {
			transaction.addToBackStack(screen.screenKey)
			localStackCopy.add(screen.screenKey)
		}

		transaction.commit()
	}

	private fun getAnimation(screen: FragmentScreen): Animations =
		if (screen is ScreenWrapper) {
			screen.animationType.animations
		} else {
			AnimationType.DEFAULT.animations
		}
}