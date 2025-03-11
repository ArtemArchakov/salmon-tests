package ph.salmon.test.data

import ph.salmon.test.client.Post
import kotlin.random.Random

object TestDataFactory {
    fun createRandomPost(): Post {
        return Post.builder()
            .id(Random.nextInt(1, 1000))
            .userId(Random.nextInt(1, 10))
            .title("Test Post ${Random.nextInt(1, 100)}")
            .body("Test Body ${Random.nextInt(1, 100)}")
            .build()
    }

    fun createPostWithoutId(userId: Int = Random.nextInt(1, 10)): Post {
        return Post.builder()
            .userId(userId)
            .title("Test Post ${Random.nextInt(1, 100)}")
            .body("Test Body ${Random.nextInt(1, 100)}")
            .build()
    }
} 