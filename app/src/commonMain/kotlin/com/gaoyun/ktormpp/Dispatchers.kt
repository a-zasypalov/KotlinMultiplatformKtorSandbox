package com.gaoyun.ktormpp

import kotlinx.coroutines.CoroutineDispatcher

internal expect val Main: CoroutineDispatcher
internal expect val Background: CoroutineDispatcher