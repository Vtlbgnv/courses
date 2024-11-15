package com.example.courses.features.mainhost.ui.section

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.courses.core.navigation.navigator.ScreenNavigator
import com.example.courses.core.navigation.utils.RouterNames.PROFILE_SECTION
import com.example.courses.features.mainhost.R
import com.example.courses.features.mainhost.presentation.section.viewmodel.ProfileSectionViewModel
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class ProfileSectionFragment : Fragment() {

	companion object {

		fun newInstance(): ProfileSectionFragment = ProfileSectionFragment()
	}

	private val viewModel: ProfileSectionViewModel by viewModel()
	private val profileSectionNavigatorHolder: NavigatorHolder by inject(named(PROFILE_SECTION))
	private val navigator: Navigator by lazy { ScreenNavigator(requireActivity(), R.id.profileSectionContainer, childFragmentManager) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
		inflater.inflate(R.layout.fragment_profile_section, container, false)

	override fun onResume() {
		super.onResume()
		profileSectionNavigatorHolder.setNavigator(navigator)
		viewModel.initRouter()
	}

	override fun onPause() {
		super.onPause()
		profileSectionNavigatorHolder.removeNavigator()
	}
}