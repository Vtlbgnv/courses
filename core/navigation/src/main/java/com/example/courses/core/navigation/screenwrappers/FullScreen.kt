package com.example.courses.core.navigation.screenwrappers

import com.example.courses.core.navigation.utils.AnimationType

open class FullScreen(
	key: String,
	createFragment: () -> FullScreenFragment,
	animationType: AnimationType = AnimationType.DEFAULT,
) : ScreenWrapper(key, createFragment, animationType)