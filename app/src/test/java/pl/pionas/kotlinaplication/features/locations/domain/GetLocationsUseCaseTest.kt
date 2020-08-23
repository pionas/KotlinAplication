package pl.pionas.kotlinaplication.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.locations.LocationRepository


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
internal class GetLocationsUseCaseTest {

    @Test
    fun `when use case is invoked than execute getLocations method from repository`() {
        // given
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getLocations() }
    }
}