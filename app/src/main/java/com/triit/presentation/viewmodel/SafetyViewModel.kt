package com.triit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triit.domain.repository.SafetyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

data class SafetyState(
    val isLoading: Boolean = false,
    val safetyTip: String = "",
    val riskLevel: String = "LOW", // LOW, MEDIUM, HIGH
    val error: String? = null
)

@HiltViewModel
class SafetyViewModel @Inject constructor(
    private val safetyRepository: SafetyRepository
) : ViewModel() {
    
    private val _safetyState = MutableStateFlow(SafetyState())
    val safetyState: StateFlow<SafetyState> = _safetyState

    fun generateSafetyTips(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _safetyState.value = _safetyState.value.copy(isLoading = true)
            try {
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                
                safetyRepository.generateSafetyTips(latitude, longitude, hour)
                    .onSuccess { tip ->
                        val riskLevel = when {
                            hour >= 22 || hour <= 5 -> "HIGH"
                            hour >= 19 && hour < 22 -> "MEDIUM"
                            else -> "LOW"
                        }
                        _safetyState.value = SafetyState(
                            isLoading = false,
                            safetyTip = tip,
                            riskLevel = riskLevel
                        )
                    }.onFailure { error ->
                        _safetyState.value = _safetyState.value.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
            } catch (e: Exception) {
                _safetyState.value = _safetyState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}
