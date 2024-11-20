package com.example.courses.features.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.courses.components.ui.theme.CoursesTheme
import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.features.profile.ui.compose.ProfileScreen

fun getProfileScreen() =
	SectionScreen(
		key = ProfileFragment::class.java.name,
		createFragment = { ProfileFragment.newInstance() },
	)

class ProfileFragment : Fragment() {

	internal companion object {

		fun newInstance() = ProfileFragment()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				CoursesTheme {
					ProfileScreen()
				}
			}
		}
}