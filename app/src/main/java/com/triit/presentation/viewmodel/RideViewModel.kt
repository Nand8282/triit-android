package com.triit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triit.domain.model.Ride
import com.triit.domain.model.RideMatch
import com.triit.domain.repository.LocationRepository
import com.triit.domain.repository.RideRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RideState(
    val isLoading: Boolean = false,
    val availableRides: List<Ride> = emptyList(),
    val rideMatches: List<RideMatch> = emptyList(),
    val userRides: List<Ride> = emptyList(),
    val selectedRide: Ride? = null,
    val error: String? = null,
    val currentLatitude: Double = 0.0,
    val currentLongitude: Double = 0.0
)

@HiltViewModel
class RideViewModel @Inject constructor(
    private val rideRepository: RideRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _rideState = MutableStateFlow(RideState())
    val rideState: StateFlow<RideState> = _rideState

    fun fetchNearbyRides() {
        viewModelScope.launch {
            _rideState.value = _rideState.value.copy(isLoading = true)
            try {
                locationRepository.getCurrentLocation()
                    .onSuccess { location ->
                        rideRepository.getNearbyRides(location.latitude, location.longitude, 400)
                            .onSuccess { rides ->
                                _rideState.value = RideState(
                                    isLoading = false,
                                    availableRides = rides,
                                    currentLatitude = location.latitude,
                                    currentLongitude = location.longitude
                                )
                            }
                            .onFailure { error ->
                                _rideState.value = _rideState.value.copy(
                                    isLoading = false,
                                    error = error.message
                                )
                            }
                    }
                    .onFailure { error ->
                        _rideState.value = _rideState.value.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
            } catch (e: Exception) {
                _rideState.value = _rideState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    fun selectRide(ride: Ride) {
        _rideState.value = _rideState.value.copy(selectedRide = ride)
    }

    fun bookRide(rideId: String, userId: String) {
        viewModelScope.launch {
            _rideState.value = _rideState.value.copy(isLoading = true)
            rideRepository.bookRide(rideId, userId)
                .onSuccess {
                    _rideState.value = _rideState.value.copy(
                        isLoading = false,
                        selectedRide = null
                    )
                    fetchNearbyRides()
                }
                .onFailure { error ->
                    _rideState.value = _rideState.value.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
        }
    }
}
