package com.mohali.newsapp_virtusa.repository

import com.mohali.newsapp_virtusa.network.NewsApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RemoteRepositoryTest {

    @Mock
    private lateinit var newsApi: NewsApi


    @InjectMocks
    private lateinit var repository: RemoteRepository


    @Test
    fun testGetBreakingNews() = runBlockingTest {
        // Given

        // When
        repository.getBreakingNews()

        // Then
        Mockito.verify(newsApi).getBreakingNews()
    }

    @Test
    fun testSearchNews() = runBlockingTest {
        // Given
        val queryText = "Something"

        // When
        repository.searchNews(queryText)

        // Then
        Mockito.verify(newsApi).searchForNews(queryText)
    }
}