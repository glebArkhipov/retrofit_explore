package com

import dev.reformator.stacktracedecoroutinator.jvm.DecoroutinatorJvmApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.debug.DebugProbes
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    configCoroutineDebug(
        turnOnDecoroutinator = false,
        turnOnDebugProbes = false
    )
    makeApiCall()
}

fun configCoroutineDebug(
    turnOnDecoroutinator: Boolean,
    turnOnDebugProbes: Boolean
) {
    if (turnOnDecoroutinator) {
        DecoroutinatorJvmApi.install()
    }
    if (turnOnDebugProbes) {
        System.setProperty(
            kotlinx.coroutines.DEBUG_PROPERTY_NAME,
            kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON
        )
        @OptIn(ExperimentalCoroutinesApi::class)
        DebugProbes.install()
        System.setProperty(
            kotlinx.coroutines.DEBUG_PROPERTY_NAME,
            kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON
        )
    }
}
