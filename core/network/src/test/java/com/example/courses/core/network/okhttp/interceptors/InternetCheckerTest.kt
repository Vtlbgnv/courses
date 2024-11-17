package com.example.courses.core.network.okhttp.interceptors

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
class InternetCheckerTest {

	private val context: Context = mock()
	private val connectivityManager: ConnectivityManager = mock()
	private val networkCapabilities = mock(NetworkCapabilities::class.java)

	@Test
	fun `no wifi and internet connection on Android M and above EXPECT false`() {
		whenever(context.getSystemService(Context.CONNECTIVITY_SERVICE)) doReturn connectivityManager
		whenever(connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)) doReturn networkCapabilities
		whenever(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) doReturn false
		whenever(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) doReturn false

		val isConnected = InternetChecker(context).connected

		assertEquals(false, isConnected)
	}

	@Test
	fun `there is internet connection on Android M and above EXPECT true`() {
		whenever(context.getSystemService(Context.CONNECTIVITY_SERVICE)) doReturn connectivityManager
		whenever(connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)) doReturn networkCapabilities
		whenever(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) doReturn false
		whenever(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) doReturn true

		val isConnected = InternetChecker(context).connected

		assertEquals(true, isConnected)
	}

	@Test
	fun `there is wi-fi connection on Android M and above EXPECT true`() {
		whenever(context.getSystemService(Context.CONNECTIVITY_SERVICE)) doReturn connectivityManager
		whenever(connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)) doReturn networkCapabilities
		whenever(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) doReturn true
		whenever(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) doReturn false

		val isConnected = InternetChecker(context).connected

		assertEquals(true, isConnected)
	}
}