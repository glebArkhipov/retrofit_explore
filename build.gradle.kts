plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val oldOkhttpVersion = "4.10.0"
val oldRetrofitVersion = "2.9.0"

val newOkhttpVersion = "4.12.0"
val newRetrofitVersion = "2.11.0"
val kotlinxCoroutinesCore = "1.9.0"

val okhttpVersion = newOkhttpVersion
val retrofitVersion = newRetrofitVersion
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesCore")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.1")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-jackson:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-scalars:$retrofitVersion")

    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")

    implementation("dev.reformator.stacktracedecoroutinator:stacktrace-decoroutinator-jvm:2.4.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-debug:$kotlinxCoroutinesCore")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
