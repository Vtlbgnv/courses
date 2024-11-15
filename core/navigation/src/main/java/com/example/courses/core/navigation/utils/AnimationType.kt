package com.example.courses.core.navigation.utils

import com.example.courses.core.navigation.R

data class Animations(
	val enter: Int,
	val exit: Int,
	val popEnter: Int,
	val popExit: Int,
)

enum class AnimationType(val animations: Animations) {
	DEFAULT(Animations(0, 0, 0, 0)),
	FADE(
		Animations(
			enter = R.anim.fade_in,
			exit = 0,
			popEnter = 0,
			popExit = R.anim.fade_out
		)
	),
	HORIZONTAL_SLIDE(
		Animations(
			enter = R.anim.slide_in,
			exit = R.anim.fade_out,
			popEnter = R.anim.fade_in,
			popExit = R.anim.slide_out
		)
	),
	VERTICAL_SLIDE(
		Animations(
			enter = R.animator.slide_up,
			exit = 0,
			popEnter = 0,
			popExit = R.animator.slide_down
		)
	),
	HORIZONTAL_PUSH(
		Animations(
			enter = R.anim.left_in,
			exit = R.anim.left_out,
			popEnter = R.anim.right_in,
			popExit = R.anim.right_out
		)
	),
}