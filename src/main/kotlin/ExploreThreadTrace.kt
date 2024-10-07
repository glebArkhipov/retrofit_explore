package com

import kotlin.concurrent.thread

fun runThreads() {
    printThread("start")
    thread1()
    printThread("end")
}

fun thread1() {
    val th1 = thread {
        printThread("thread1 start")
        throw Exception("th1 fail")
    }
    th1.start()
    printThread("th1.start()")
    th1.join()
    printThread("th1.join()")
}

fun printThread(message: String) = println("${Thread.currentThread().name}: $message")
