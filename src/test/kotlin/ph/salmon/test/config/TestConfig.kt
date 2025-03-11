package ph.salmon.test.config

object TestConfig {
    val baseUrl: String = System.getenv("BASE_URL") ?: "https://jsonplaceholder.typicode.com"
    val timeout: Long = System.getenv("TIMEOUT")?.toLong() ?: 20
    val apiPath: String = System.getenv("API_PATH") ?: "/posts"
} 