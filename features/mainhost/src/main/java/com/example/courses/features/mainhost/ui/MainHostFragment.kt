package com.example.courses.features.mainhost.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import com.example.courses.core.navigation.navigator.KeepStateNavigator
import com.example.courses.core.navigation.screenwrappers.FullScreenFragment
import com.example.courses.core.navigation.utils.RouterNames.MAIN_HOST
import com.example.courses.features.mainhost.R
import com.example.courses.features.mainhost.presentation.MainHostViewModel
import com.example.courses.features.mainhost.ui.compose.NavBar
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainHostFragment : FullScreenFragment() {

	companion object {

		fun newInstance(): MainHostFragment = MainHostFragment()
	}

	private val viewModel: MainHostViewModel by viewModel()
	private val mainHostNavigatorHolder: NavigatorHolder by inject(named(MAIN_HOST))
	private val navigator by lazy { KeepStateNavigator(requireActivity(), R.id.mainHostContainer, childFragmentManager) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		return inflater.inflate(R.layout.fragment_main_host, container, false)
			.apply {
				findViewById<ComposeView>(R.id.navigatorContainer).setContent {

					MaterialTheme {
						NavBar(viewModel)
					}
				}
			}
	}

	override fun onResume() {
		super.onResume()
		mainHostNavigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		super.onPause()
		mainHostNavigatorHolder.removeNavigator()
	}

	override fun navigateBack() {
		viewModel.navigateBack()
	}
}