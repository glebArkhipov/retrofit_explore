package com

import kotlinx.coroutines.*


fun runLaunchCoroutines() = runBlocking {
    printThread("runBlocking start")
    cor1(this)
    delay(1)
    printThread("runBlocking end")
}

private suspend fun cor1(scope: CoroutineScope) {
    printThread("cor1 start")
    // if I use Dispatchers.Unconfined, then trace will contain information
    // that chain is following
    // throw Exception <- launch <- cor1 <- runCoroutines <- main
    // if new thread is used, then stack trace is short throw Exception
    val job = scope.launch(Dispatchers.IO) {
        printThread("lets throw exception")
        throw Exception("fail cor1")
    }
    job.join()
    printThread("cor1 end")
}
