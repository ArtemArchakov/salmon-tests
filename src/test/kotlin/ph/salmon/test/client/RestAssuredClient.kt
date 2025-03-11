package ph.salmon.test.client

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response
import ph.salmon.test.config.TestConfig
import ph.salmon.test.utils.TestLogger

class RestAssuredClient : PostsApiClient {
    init {
        RestAssured.baseURI = TestConfig.baseUrl
        RestAssured.basePath = TestConfig.apiPath
    }

    override fun get(endpoint: String): Response {
        TestLogger.logStep("GET request to $endpoint")
        return RestAssured.get(endpoint)
    }

    override fun post(endpoint: String, body: Any): Response {
        TestLogger.logStep("POST request to $endpoint")
        return RestAssured.given()
            .contentType(ContentType.JSON)
            .body(body)
            .post(endpoint)
    }

    override fun put(endpoint: String, body: Any): Response {
        TestLogger.logStep("PUT request to $endpoint")
        return RestAssured.given()
            .contentType(ContentType.JSON)
            .body(body)
            .put(endpoint)
    }

    override fun patch(endpoint: String, body: Any): Response {
        TestLogger.logStep("PATCH request to $endpoint")
        return RestAssured.given()
            .contentType(ContentType.JSON)
            .body(body)
            .patch(endpoint)
    }

    override fun delete(endpoint: String): Response {
        TestLogger.logStep("DELETE request to $endpoint")
        return RestAssured.delete(endpoint)
    }

    override fun getAllPosts(): Response {
        TestLogger.logStep("Getting all posts")
        return get("")
    }

    override fun getPost(id: Int): Response {
        TestLogger.logStep("Getting post with id: $id")
        return get("/$id")
    }

    override fun createPost(post: Post): Response {
        TestLogger.logStep("Creating new post")
        return post("", post)
    }

    override fun updatePost(id: Int, post: Post): Response {
        TestLogger.logStep("Updating post with id: $id")
        return put("/$id", post)
    }

    override fun patchPost(id: Int, updates: Map<String, Any>): Response {
        TestLogger.logStep("Patching post with id: $id")
        return patch("/$id", updates)
    }

    override fun deletePost(id: Int): Response {
        TestLogger.logStep("Deleting post with id: $id")
        return delete("/$id")
    }

    override fun getPostsByUserId(userId: Int): Response {
        TestLogger.logStep("Getting posts for user id: $userId")
        return get("?userId=$userId")
    }
} 