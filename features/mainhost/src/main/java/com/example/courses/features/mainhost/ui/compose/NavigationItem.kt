package com.example.courses.features.mainhost.ui.compose

import androidx.compose.runtime.Composable
import com.example.courses.core.navigation.utils.SectionNames

data class NavigationItem(
	val title: String,
	val sectionName: SectionNames,
	val icon: @Composable () -> Unit,
	val navigateToSection: () -> Unit,
)