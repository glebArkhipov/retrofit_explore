package com

import dev.reformator.stacktracedecoroutinator.jvm.DecoroutinatorJvmApi
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    configCoroutineDebug()
    makeApiCall()
}


fun configCoroutineDebug() {
    DecoroutinatorJvmApi.install()
//    System.setProperty(
//        kotlinx.coroutines.DEBUG_PROPERTY_NAME,
//        kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON
//    )
//    DebugProbes.install()
//    System.setProperty(
//        kotlinx.coroutines.DEBUG_PROPERTY_NAME,
//        kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON
//    )
}
