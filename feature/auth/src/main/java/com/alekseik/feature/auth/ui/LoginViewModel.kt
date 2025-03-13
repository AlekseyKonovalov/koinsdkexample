package com.alekseik.feature.auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alekseik.feature.auth.data.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val success = authRepository.login(email, password)
                if (success) {
                    _uiState.value = LoginUiState.Success
                } else {
                    _uiState.value = LoginUiState.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                _uiState.value = LoginUiState.Error("An error occurred")
            }
        }
    }
}

sealed class LoginUiState {
    object Initial : LoginUiState()
    object Success : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}