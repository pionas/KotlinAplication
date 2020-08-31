package pl.pionas.kotlinaplication.features.users.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.login.repository.AuthRepository

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
internal class GetAuthUseCaseTest {

    @Test
    fun `when use case is invoked than execute login method from repository`() {
        // given
        val user = User("username", "password")
        val repository = mockk<AuthRepository>(relaxed = true)
        val useCase = GetAuthUseCase(repository)

        // when
        useCase(
            params = user,
            scope = GlobalScope
        )

        // then
        coVerify { repository.login(user) }
    }
}