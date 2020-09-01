package pl.pionas.kotlinaplication.features.locations.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable
import pl.pionas.kotlinaplication.features.locations.domain.GetLocationsUseCase
import pl.pionas.kotlinaplication.features.locations.domain.model.Location
import pl.pionas.kotlinaplication.features.locations.navigation.LocationNavigator

public class LocationsViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val locationNavigator: LocationNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {
    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also {
                getEpisodes(it)
            }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { episodes ->
            episodes.map { LocationDisplayable(it) }
        }
    }

    private fun getEpisodes(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationsUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure {
                handleFailure(it)
            }
        }
    }

    fun onLocationClick(location: LocationDisplayable) {
        locationNavigator.openLocationDetailsScreen(location)
    }
}