package com.example.courses.core.network.okhttp.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever

class NoConnectionInterceptorTest {

	private val internetChecker: InternetChecker = mock()
	private val chain: Interceptor.Chain = mock()
	private val response: Response = mock()
	private val request: Request = mock()

	@Test
	fun `internet is not connected EXPECT exception`() {
		whenever(internetChecker.connected) doReturn false

		val actual = assertThrows(NoConnectivityException::class.java) {
			NoConnectionInterceptor(
				internetChecker = internetChecker,
			).intercept(chain)
		}

		assertEquals(null, actual.message)
	}

	@Test
	fun `internet is connected EXPECT chain`() {
		whenever(internetChecker.connected) doReturn true
		whenever(chain.request()) doReturn request
		whenever(chain.proceed(request)) doReturn response

		val actual = NoConnectionInterceptor(
			internetChecker = internetChecker,
		).intercept(chain)

		assertEquals(response, actual)
	}
}