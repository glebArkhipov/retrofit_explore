package com

import kotlinx.coroutines.*

/**
 * Main idea - to show that exceptions' stack trace misses frames from different threads
 * cor1 is started in thread-1
 * cor1 is continued in thread-2 and Exception("fail cor1") is thrown from thread-2
 * The exception's stack trace does not point to methods `run` and `runCoroutines`
 */
fun runCoroutines() = runBlocking(newFixedThreadPoolContext(50, "Fixed threads")) {
    run(this)
}

private suspend fun run(scope: CoroutineScope) {
    printThread("runBlocking start")
    scope.launch {
        printThread("to stole thread")
        delay(100)
        printThread("was stolen thread")
    }
    cor1()
}

private suspend fun cor1() {
    printThread("cor1 start")
    delay(100)
    printThread("lets throw exception")
    throw Exception("fail cor1")
}

