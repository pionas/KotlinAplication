package pl.pionas.kotlinaplication.features.users.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */

internal class AuthUseCaseTest {

    @Test
    fun `when use case is invoked than execute login method from repository`() {
        // given
        val user = UserCredential("username", "password")
        val repository = mockk<UserRepository>(relaxed = true)
        val useCase = AuthUseCase(repository)

        // when
        useCase(
            params = user,
            scope = GlobalScope
        )

        // then
        coVerify { repository.auth(user) }
    }
}