package ph.salmon.test.client

data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) {
    class Builder {
        private var id: Int = 0
        private var userId: Int = 0
        private var title: String = ""
        private var body: String = ""

        fun withId(id: Int) = apply { this.id = id }
        fun withUserId(userId: Int) = apply { this.userId = userId }
        fun withTitle(title: String) = apply { this.title = title }
        fun withBody(body: String) = apply { this.body = body }
        
        fun build() = Post(id, userId, title, body)
    }

    companion object {
        fun builder() = Builder()
    }
} 