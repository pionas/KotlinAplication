package pl.pionas.kotlinaplication.features.locations

import pl.pionas.kotlinaplication.features.locations.domain.model.Location


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
interface LocationRepository {
    suspend fun getLocations(): List<Location>
}