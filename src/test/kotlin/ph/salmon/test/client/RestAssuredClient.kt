package ph.salmon.test.client

import io.restassured.RestAssured
import io.restassured.response.Response
import ph.salmon.test.config.TestConfig

class RestAssuredClient : ApiClient {
    init {
        RestAssured.baseURI = TestConfig.baseUrl
    }

    override fun get(endpoint: String): Response {
        return RestAssured.given()
            .get(endpoint)
    }

    override fun post(endpoint: String, body: Any): Response {
        return RestAssured.given()
            .body(body)
            .post(endpoint)
    }

    override fun put(endpoint: String, body: Any): Response {
        return RestAssured.given()
            .body(body)
            .put(endpoint)
    }

    override fun delete(endpoint: String): Response {
        return RestAssured.given()
            .delete(endpoint)
    }
} 