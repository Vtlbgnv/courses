package com.example.courses.features.mainhost.ui.section

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.courses.core.navigation.navigator.ScreenNavigator
import com.example.courses.core.navigation.utils.RouterNames.FAVORITES_SECTION
import com.example.courses.features.mainhost.R
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import com.example.courses.features.mainhost.presentation.section.viewmodel.FavoritesSectionViewModel

class FavoritesSectionFragment : Fragment() {

	companion object {

		fun newInstance(): FavoritesSectionFragment = FavoritesSectionFragment()
	}

	private val viewModel: FavoritesSectionViewModel by viewModel()
	private val favoritesSectionNavigatorHolder: NavigatorHolder by inject(named(FAVORITES_SECTION))
	private val navigator: Navigator by lazy { ScreenNavigator(requireActivity(), R.id.favoritesSectionContainer, childFragmentManager) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
		inflater.inflate(R.layout.fragment_favorites_section, container, false)

	override fun onResume() {
		super.onResume()
		favoritesSectionNavigatorHolder.setNavigator(navigator)
		viewModel.initRouter()
	}

	override fun onPause() {
		super.onPause()
		favoritesSectionNavigatorHolder.removeNavigator()
	}
}