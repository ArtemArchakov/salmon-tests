package ph.salmon.test.utils

import io.qameta.allure.Allure
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TestLogger {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")

    fun logStep(step: String) {
        val timestamp = LocalDateTime.now().format(dateFormatter)
        val logMessage = "[$timestamp] $step"
        println(logMessage)
        Allure.step(step)
    }

    fun logInfo(message: String) {
        val timestamp = LocalDateTime.now().format(dateFormatter)
        println("[$timestamp] [INFO] $message")
    }

    fun logError(message: String, error: Throwable? = null) {
        val timestamp = LocalDateTime.now().format(dateFormatter)
        println("[$timestamp] [ERROR] $message")
        error?.let { println("[$timestamp] [ERROR] ${it.stackTraceToString()}") }
    }
} 