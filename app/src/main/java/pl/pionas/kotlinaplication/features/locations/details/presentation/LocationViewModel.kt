package pl.pionas.kotlinaplication.features.locations.details.presentation

import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class LocationViewModel : BaseViewModel() {
    var locationDisplayable: LocationDisplayable? = null
}