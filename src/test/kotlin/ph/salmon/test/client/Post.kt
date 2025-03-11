package ph.salmon.test.client

data class Post(
    val id: Int?,
    val userId: Int,
    val title: String,
    val body: String
) {
    data class Builder(
        var id: Int? = null,
        var userId: Int = 1,
        var title: String = "",
        var body: String = ""
    ) {
        fun id(id: Int?) = apply { this.id = id }
        fun userId(userId: Int) = apply { this.userId = userId }
        fun title(title: String) = apply { this.title = title }
        fun body(body: String) = apply { this.body = body }
        fun build() = Post(id, userId, title, body)
    }

    companion object {
        fun builder() = Builder()
    }
} 