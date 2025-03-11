package ph.salmon.test.utils

import org.slf4j.LoggerFactory

object TestLogger {
    private val logger = LoggerFactory.getLogger(TestLogger::class.java)

    fun info(message: String) {
        logger.info(message)
    }

    fun error(message: String, throwable: Throwable? = null) {
        if (throwable != null) {
            logger.error(message, throwable)
        } else {
            logger.error(message)
        }
    }

    fun debug(message: String) {
        logger.debug(message)
    }
} 