package com.medical.a99houselistingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medical.a99houselistingapp.data.model.Listing
import com.medical.a99houselistingapp.data.repository.ListingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface SearchResultUiState {
    object Loading : SearchResultUiState
    data class Success(val listings: List<Listing>) : SearchResultUiState
    data class Error(val message: String) : SearchResultUiState
}

// gets data, process it, and manage which UI state to display
class SearchResultViewModel (
    private val repository: ListingRepository = ListingRepository()
) : ViewModel() {
    private val _uiState = MutableStateFlow<SearchResultUiState>(SearchResultUiState.Loading)
    val uiState: StateFlow<SearchResultUiState> = _uiState

    init {
        fetchListings()
    }

    private fun fetchListings() {
        viewModelScope.launch {
            _uiState.value = SearchResultUiState.Loading
            try {
                val listings = repository.getListings()
                _uiState.value = SearchResultUiState.Success(listings)
            } catch (e: Exception) {
                _uiState.value = SearchResultUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}