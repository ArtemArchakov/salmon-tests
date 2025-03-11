package ph.salmon.test.client

import io.restassured.response.Response

interface ApiClient {
    fun get(endpoint: String): Response
    fun post(endpoint: String, body: Any): Response
    fun put(endpoint: String, body: Any): Response
    fun delete(endpoint: String): Response
} 