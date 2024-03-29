package com.nfragiskatos.news_api_client.data.api

import com.nfragiskatos.news_api_client.BuildConfig
import com.nfragiskatos.news_api_client.data.model.APIResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.common.truth.Truth.assertThat
import com.nfragiskatos.news_api_client.data.model.Article

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val body: APIResponse? = service.getTopHeadlines("us", 1).body()
            val request = server.takeRequest()

            assertThat(body).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=${BuildConfig.NEWS_API_KEY}")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val body: APIResponse? = service.getTopHeadlines("us", 1).body()
            val articles: List<Article> = body!!.articles

            assertThat(articles.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val body: APIResponse? = service.getTopHeadlines("us", 1).body()
            val articles: List<Article> = body!!.articles
            val article = articles[0]

            assertThat(article.author).isEqualTo("Shehan Jeyarajah")
            assertThat(article.url).isEqualTo("https://www.cbssports.com/college-football/news/oklahoma-vs-texas-score-takeaways-caleb-williams-propels-sooners-to-largest-comeback-in-red-river-history/live/")
            assertThat(article.publishedAt).isEqualTo("2021-10-09T20:37:00Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}