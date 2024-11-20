package com.example.courses.navigation.router

import android.content.Intent
import android.net.Uri
import com.github.terrakok.cicerone.androidx.ActivityScreen

internal fun getLinkScreen(url: String): ActivityScreen =
	ActivityScreen { Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) } }