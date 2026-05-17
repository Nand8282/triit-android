package com.triit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triit.domain.model.User
import com.triit.domain.model.VehicleDetails
import com.triit.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthState(
    val isLoading: Boolean = false,
    val currentUser: User? = null,
    val isAuthenticated: Boolean = false,
    val error: String? = null,
    val otpSent: Boolean = false,
    val phoneNumber: String = ""
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _authState = MutableStateFlow(AuthState())
    val authState: StateFlow<AuthState> = _authState

    fun sendOTP(phone: String) {
        viewModelScope.launch {
            _authState.value = _authState.value.copy(isLoading = true)
            userRepository.sendOTP(phone)
                .onSuccess {
                    _authState.value = AuthState(
                        isLoading = false,
                        otpSent = true,
                        phoneNumber = phone
                    )
                }
                .onFailure { error ->
                    _authState.value = _authState.value.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
        }
    }

    fun verifyOTP(phone: String, otp: String) {
        viewModelScope.launch {
            _authState.value = _authState.value.copy(isLoading = true)
            userRepository.verifyOTP(phone, otp)
                .onSuccess { userId ->
                    _authState.value = AuthState(
                        isLoading = false,
                        isAuthenticated = true
                    )
                }
                .onFailure { error ->
                    _authState.value = _authState.value.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
        }
    }

    fun signUpUser(name: String, email: String, gender: String, vehicleDetails: VehicleDetails?) {
        viewModelScope.launch {
            _authState.value = _authState.value.copy(isLoading = true)
            val newUser = User(
                name = name,
                email = email,
                phone = _authState.value.phoneNumber,
                gender = gender,
                vehicleDetails = vehicleDetails
            )
            userRepository.signUpUser(newUser)
                .onSuccess { userId ->
                    _authState.value = AuthState(
                        isLoading = false,
                        isAuthenticated = true,
                        currentUser = newUser.copy(id = userId)
                    )
                }
                .onFailure { error ->
                    _authState.value = _authState.value.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
            _authState.value = AuthState()
        }
    }
}
