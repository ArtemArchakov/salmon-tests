package ph.salmon.test.client

import io.restassured.response.Response

interface ApiClient {
    fun get(endpoint: String): Response
    fun post(endpoint: String, body: Any): Response
    fun put(endpoint: String, body: Any): Response
    fun patch(endpoint: String, body: Any): Response
    fun delete(endpoint: String): Response
}

interface PostsApiClient : ApiClient {
    fun getAllPosts(): Response
    fun getPost(id: Int): Response
    fun createPost(post: Post): Response
    fun updatePost(id: Int, post: Post): Response
    fun patchPost(id: Int, updates: Map<String, Any>): Response
    fun deletePost(id: Int): Response
    fun getPostsByUserId(userId: Int): Response
} 