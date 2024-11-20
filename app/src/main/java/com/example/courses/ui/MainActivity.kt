package com.example.courses.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.courses.R
import com.example.courses.core.navigation.navigator.ScreenNavigator
import com.example.courses.core.navigation.utils.RouterNames.FULL_SCREEN
import com.example.courses.databinding.ActivityMainBinding
import com.example.courses.presentation.MainViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

	private val fullScreenNavigatorHolder: NavigatorHolder by inject(named(FULL_SCREEN))
	private val navigator = ScreenNavigator(this, R.id.globalContainer)
	private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	private val viewModel: MainViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		WindowCompat.setDecorFitsSystemWindows(
			window,
			true
		)
		setContentView(binding.root)
		viewModel.setStartScreen()

		window.apply {
			decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
			statusBarColor = Color.TRANSPARENT
		}
	}

	override fun onResume() {
		super.onResume()
		fullScreenNavigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		super.onPause()
		fullScreenNavigatorHolder.removeNavigator()
	}
}