package com.medical.a99houselistingapp.viewmodel

import android.crypto.hpke.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medical.a99houselistingapp.data.model.ListingDetail
import com.medical.a99houselistingapp.data.repository.ListingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface ListingDetailUiState {
    object Loading : ListingDetailUiState
    data class Success(val listing: ListingDetail) : ListingDetailUiState
    data class Error(val message: String) : ListingDetailUiState
}

class ListingDetailViewModel(
    private  val repository: ListingRepository = ListingRepository()
) : ViewModel() {
    private val _uiState = MutableStateFlow<ListingDetailUiState>(ListingDetailUiState.Loading)
    val uiState: StateFlow<ListingDetailUiState> = _uiState

    fun fetchListingDetail(id: Int) {
        viewModelScope.launch {
            _uiState.value = ListingDetailUiState.Loading
            try {
                val detail = repository.getListingDetail(id)
                _uiState.value = ListingDetailUiState.Success(detail)
            } catch (e: Exception) {
                _uiState.value = ListingDetailUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}