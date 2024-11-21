package com.example.courses.features.userfavorites.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.courses.components.ui.theme.CoursesTheme
import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.features.userfavorites.presentation.UserFavoritesViewModel
import com.example.courses.features.userfavorites.ui.compose.UserFavoritesScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

fun getUserFavoritesFragmentScreen() =
	SectionScreen(
		key = UserFavoritesFragment::class.java.name,
		createFragment = { UserFavoritesFragment.newInstance() },
	)

class UserFavoritesFragment : Fragment() {

	internal companion object {

		fun newInstance() = UserFavoritesFragment()
	}

	private val viewModel: UserFavoritesViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				CoursesTheme {
					UserFavoritesScreen(
						uiState = viewModel.uiState,
						applyIntent = viewModel::applyIntent,
					)
				}
			}
		}
}