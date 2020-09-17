package pl.pionas.kotlinaplication.features.users.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */

internal class GetUsersUseCaseTest {

    @Test
    fun `when use case is invoked than execute getUsers method from repository`() {
        // given
        val repository = mockk<UserRepository>(relaxed = true)
        val useCase = GetUsersUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getUsers() }
    }
}