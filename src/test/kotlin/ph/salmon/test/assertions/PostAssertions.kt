package ph.salmon.test.assertions

import io.restassured.response.Response
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import ph.salmon.test.client.Post
import ph.salmon.test.utils.TestLogger
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PostAssertions {
    private val gson = Gson()

    fun assertPostEquals(actual: Post, expected: Post) {
        TestLogger.logStep("Asserting post equality")
        assertThat(actual.id, equalTo(expected.id))
        assertThat(actual.userId, equalTo(expected.userId))
        assertThat(actual.title, equalTo(expected.title))
        assertThat(actual.body, equalTo(expected.body))
    }

    fun assertStatusCode(response: Response, expectedCode: Int) {
        TestLogger.logStep("Asserting status code is $expectedCode")
        assertThat(response.statusCode, equalTo(expectedCode))
    }

    fun assertPostsCount(response: Response, expectedCount: Int) {
        TestLogger.logStep("Asserting posts count is $expectedCount")
        val listType = object : TypeToken<List<Post>>() {}.type
        val posts = gson.fromJson<List<Post>>(response.body().asString(), listType)
        assertThat(posts.size, equalTo(expectedCount))
    }

    fun assertAllPostsBelongToUser(response: Response, userId: Int) {
        TestLogger.logStep("Asserting all posts belong to user $userId")
        val listType = object : TypeToken<List<Post>>() {}.type
        val posts = gson.fromJson<List<Post>>(response.body().asString(), listType)
        assertThat(posts, everyItem(hasProperty("userId", equalTo(userId))))
    }

    fun assertPostTitle(response: Response, expectedTitle: String) {
        TestLogger.logStep("Asserting post title is '$expectedTitle'")
        val post = gson.fromJson(response.body().asString(), Post::class.java)
        assertThat(post.title, equalTo(expectedTitle))
    }
} 