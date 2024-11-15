package com.example.courses.features.mainhost

import com.example.courses.core.navigation.screenwrappers.FullScreen
import com.example.courses.core.navigation.screenwrappers.FullScreenFragment

class MainHostScreen(
	key: String,
	createFragment: () -> FullScreenFragment,
) : FullScreen(key, createFragment)