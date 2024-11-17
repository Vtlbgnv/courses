package com.example.courses.components.ui.compose

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun Pagination(
	lazyListState: LazyListState,
	itemsCount: Int,
	hasPrevious: Boolean,
	hasNext: Boolean,
	priorItemsCount: Int,
	loadThreshold: Int = 6,
	onLoadMore: () -> Unit,
	onLoadPrevious: () -> Unit,
) {
	val stateInfo by remember { derivedStateOf { lazyListState.layoutInfo } }
	val lastIndex = stateInfo.visibleItemsInfo.lastOrNull()?.index ?: Int.MIN_VALUE
	val firstIndex = stateInfo.visibleItemsInfo.firstOrNull()?.index ?: Int.MAX_VALUE

	if (lastIndex - priorItemsCount >= (itemsCount - loadThreshold) && hasNext) {
		LaunchedEffect(itemsCount) {
			onLoadMore()
		}
	}

	if (firstIndex <= loadThreshold && hasPrevious) {
		LaunchedEffect(itemsCount) {
			onLoadPrevious()
		}
	}
}