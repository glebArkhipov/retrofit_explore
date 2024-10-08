package com

import dev.reformator.stacktracedecoroutinator.jvm.DecoroutinatorJvmApi
import kotlinx.coroutines.runBlocking

fun main() {
    configCoroutineDebug(
        turnOnDecoroutinator = false,
        turnOnDebugProbes = true,
    )
    runBlocking { makeApiCall() }
}

fun configCoroutineDebug(
    turnOnDecoroutinator: Boolean,
    turnOnDebugProbes: Boolean,
) {
    if (turnOnDecoroutinator) {
        DecoroutinatorJvmApi.install()
    }
    if (turnOnDebugProbes) {
        System.setProperty(
            kotlinx.coroutines.DEBUG_PROPERTY_NAME,
            kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON,
        )
    }
}
