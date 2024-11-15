package com.example.courses.core.navigation.screenwrappers

import androidx.activity.addCallback
import androidx.fragment.app.Fragment

abstract class FullScreenFragment : Fragment() {

	abstract fun navigateBack()

	override fun onStart() {
		requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
			navigateBack()
		}
		super.onStart()
	}
}