package com.example.courses.core.navigation.screenwrappers

import androidx.fragment.app.Fragment
import com.example.courses.core.navigation.utils.AnimationType

class InnerSectionScreen(
	key: String,
	createFragment: () -> Fragment,
	animationType: AnimationType = AnimationType.DEFAULT,
) : ScreenWrapper(key, createFragment, animationType)