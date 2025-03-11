package ph.salmon.test

import io.qameta.allure.AllureId
import io.qameta.allure.Issue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import ph.salmon.test.assertions.PostAssertions
import ph.salmon.test.client.Post
import ph.salmon.test.client.RestAssuredClient
import ph.salmon.test.data.TestDataFactory
import com.google.gson.Gson
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostsTest {
    private lateinit var apiClient: RestAssuredClient
    private val gson = Gson()

    @BeforeAll
    fun setUp() {
        apiClient = RestAssuredClient()
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `get a post`() {
        val expectedPost = Post(
            id = 1,
            userId = 1,
            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto"
        )
        
        val response = apiClient.getPost(1)
        val actualPost = gson.fromJson(response.body().asString(), Post::class.java)
        
        PostAssertions.assertStatusCode(response, 200)
        PostAssertions.assertPostEquals(actualPost, expectedPost)
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `check posts amount`() {
        val response = apiClient.getAllPosts()
        PostAssertions.assertStatusCode(response, 200)
        PostAssertions.assertPostsCount(response, 100)
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `create a post`() {
        val newPost = TestDataFactory.createRandomPost()
        val response = apiClient.createPost(newPost)
        val actualPost = gson.fromJson(response.body().asString(), Post::class.java)
        
        PostAssertions.assertStatusCode(response, 201)
        assertThat(actualPost.userId, equalTo(newPost.userId))
        assertThat(actualPost.title, equalTo(newPost.title))
        assertThat(actualPost.body, equalTo(newPost.body))
        assertThat(actualPost.id, notNullValue())
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `update a post`() {
        val expectedPost = TestDataFactory.createPostWithId(1)
        val response = apiClient.updatePost(1, expectedPost)
        val actualPost = gson.fromJson(response.body().asString(), Post::class.java)
        
        PostAssertions.assertStatusCode(response, 200)
        PostAssertions.assertPostEquals(actualPost, expectedPost)
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `patch a post`() {
        val newTitle = mapOf("title" to "new title")
        val response = apiClient.patchPost(1, newTitle)
        
        PostAssertions.assertStatusCode(response, 200)
        PostAssertions.assertPostTitle(response, newTitle["title"]!!)
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `delete a post`() {
        val response = apiClient.deletePost(1)
        PostAssertions.assertStatusCode(response, 200)
    }

    @Test
    @AllureId("some generated id")
    @Issue("some issue/task id")
    fun `get posts filtered by user_id`() {
        val userId = 1
        val response = apiClient.getPostsByUserId(userId)
        
        PostAssertions.assertStatusCode(response, 200)
        PostAssertions.assertAllPostsBelongToUser(response, userId)
    }
}
