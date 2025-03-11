package ph.salmon.test.data

import ph.salmon.test.client.Post
import kotlin.random.Random
import java.util.UUID

object TestDataFactory {
    fun createRandomPost() = Post(
        id = Random.nextInt(1000),
        userId = Random.nextInt(100),
        title = "Test title ${UUID.randomUUID()}",
        body = "Test body ${UUID.randomUUID()}"
    )

    fun createPostWithId(id: Int) = Post(
        id = id,
        userId = Random.nextInt(100),
        title = "Test title for post $id",
        body = "Test body for post $id"
    )

    fun createPostWithUserId(userId: Int) = Post(
        id = Random.nextInt(1000),
        userId = userId,
        title = "Test title for user $userId",
        body = "Test body for user $userId"
    )
} 