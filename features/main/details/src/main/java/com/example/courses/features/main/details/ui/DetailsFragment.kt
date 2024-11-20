package com.example.courses.features.main.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.courses.components.ui.theme.CoursesTheme
import com.example.courses.core.navigation.screenwrappers.InnerSectionScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

fun getDetailsScreen(
	courseId: Int
) = InnerSectionScreen(
	key = DetailsFragment::class.java.name,
	createFragment = {
		DetailsFragment.newInstance(
			courseId = courseId,
		)
	},
)

class DetailsFragment : Fragment() {

	internal companion object {

		private const val COURSE_ID_KEY = "COURSE_ID_KEY"

		fun newInstance(courseId: Int) = DetailsFragment().apply {
			arguments = bundleOf(
				COURSE_ID_KEY to courseId
			)
		}
	}

	private val viewModel: com.example.courses.features.main.details.presentation.DetailsViewModel by viewModel {
		parametersOf(
			requireArguments().getInt(COURSE_ID_KEY)
		)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				CoursesTheme {
					com.example.courses.features.main.details.ui.compose.DetailsScreen(
						uiState = viewModel.uiState,
						applyIntent = viewModel::applyIntent,
						uiEventFlow = viewModel.uiEvent
					)
				}
			}
		}
}