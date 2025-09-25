package com.example.countrypicker.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrypicker.Models.CountryCodesModel
import com.example.countrypicker.Models.createCountry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhonePickerViewModel : ViewModel() {

    private val _selectedCountry = MutableStateFlow(countries.first())
    val selectedCountry: StateFlow<CountryCodesModel> = _selectedCountry
    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber
    private val _showSheet = MutableStateFlow(false)
    val showSheet: StateFlow<Boolean> = _showSheet

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun onPhoneChanged(newNumber: String, country: CountryCodesModel) {
        if (newNumber.length <= country.numberLength) {
            _phoneNumber.value = newNumber
        }
    }
    fun toggleSheet(show: Boolean) {
        _showSheet.value = show
    }

    fun selectCountry(country: CountryCodesModel) {
        viewModelScope.launch {
            _selectedCountry.emit(country)
            _showSheet.emit(false)
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun filteredCountries(): List<CountryCodesModel> {
        val query = _searchQuery.value.lowercase()
        return if (query.isEmpty()) {
            countries
        } else {
            countries.filter {
                it.name.lowercase().contains(query) ||
                        it.code.contains(query)
            }
        }
    }
}



val countries = listOf(
    createCountry("Afghanistan", "+93", "🇦🇫", 9, "7"),
    createCountry("Albania", "+355", "🇦🇱", 9, "6"),
    createCountry("Algeria", "+213", "🇩🇿", 9, "5"),
    createCountry("American Samoa", "+1-684", "🇦🇸", 7, "6"),
    createCountry("Andorra", "+376", "🇦🇩", 6, "3"),
    createCountry("Australia", "+61", "🇦🇺", 9, "4"),
    createCountry("Canada", "+1", "🇨🇦", 10, "4"),
    createCountry("Egypt", "+20", "🇪🇬", 10, "1"),
    createCountry("France", "+33", "🇫🇷", 9, "6"),
    createCountry("Germany", "+49", "🇩🇪", 10, "1"),
    createCountry("Italy", "+39", "🇮🇹", 9, "3"),
    createCountry("Kuwait", "+965", "🇰🇼", 8, "5"),
    createCountry("Morocco", "+212", "🇲🇦", 9, "6"),
    createCountry("Qatar", "+974", "🇶🇦", 8, "3"),
    createCountry("Saudi Arabia", "+966", "🇸🇦", 9, "5"),
    createCountry("South Africa", "+27", "🇿🇦", 9, "6"),
    createCountry("Spain", "+34", "🇪🇸", 9, "6"),
    createCountry("United Arab Emirates", "+971", "🇦🇪", 9, "5"),
    createCountry("United Kingdom", "+44", "🇬🇧", 10, "7"),
    createCountry("United States", "+1", "🇺🇸", 10, "2")
).sortedBy { it.name }


