package com.example.courses.core.navigation.screenwrappers

import androidx.fragment.app.Fragment
import com.example.courses.core.navigation.utils.AnimationType

class SectionScreen(
	key: String,
	createFragment: () -> Fragment,
) : ScreenWrapper(key, createFragment, AnimationType.DEFAULT)