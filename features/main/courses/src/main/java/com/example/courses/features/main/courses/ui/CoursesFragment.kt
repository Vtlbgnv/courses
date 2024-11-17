package com.example.courses.features.main.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.courses.components.ui.theme.CoursesTheme
import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.features.main.courses.presentation.CoursesIntent
import com.example.courses.features.main.courses.presentation.CoursesViewModel
import com.example.courses.features.main.courses.ui.compose.CoursesScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

fun getCoursesScreen() =
	SectionScreen(
		key = CoursesFragment::class.java.name,
		createFragment = { CoursesFragment.newInstance() },
	)

class CoursesFragment : Fragment() {

	internal companion object {

		fun newInstance() = CoursesFragment()
	}

	private val viewModel: CoursesViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			viewModel.applyIntent(CoursesIntent.LoadCourses)
			setContent {
				CoursesTheme {
					CoursesScreen(
						uiState = viewModel.uiState,
						applyIntent = viewModel::applyIntent,
						uiEventFlow = viewModel.uiEvent,
					)
				}
			}
		}
}