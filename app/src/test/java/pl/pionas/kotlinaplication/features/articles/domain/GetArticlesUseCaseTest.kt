package pl.pionas.kotlinaplication.features.articles.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleRepository


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
internal class GetArticlesUseCaseTest {

    @Test
    fun `when use case is invoked than execute getArticles method from repository`() {
        // given
        val repository = mockk<ArticleRepository>(relaxed = true)
        val useCase = GetArticlesUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getArticles() }
    }
}