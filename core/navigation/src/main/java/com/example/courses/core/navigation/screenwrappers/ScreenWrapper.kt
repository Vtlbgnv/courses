package com.example.courses.core.navigation.screenwrappers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.courses.core.navigation.utils.AnimationType
import com.github.terrakok.cicerone.androidx.FragmentScreen

abstract class ScreenWrapper(
	private val key: String,
	private val createFragment: () -> Fragment,
	val animationType: AnimationType,
) : FragmentScreen {

	override val screenKey: String
		get() = key

	override fun createFragment(factory: FragmentFactory): Fragment = createFragment()
}