package nbt.party.o.matsosik.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.repo.MatsosikRepository
import nbt.party.o.matsosik.di.RealMatsosikRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    @RealMatsosikRepository private val matsosikRepository: MatsosikRepository
) : ViewModel() {

    private val _restaurants: MutableStateFlow<List<RestaurantData>> =
        MutableStateFlow(listOf())
    val restaurants: StateFlow<List<RestaurantData>>
        get() = _restaurants.asStateFlow()

    init {
        fetchRestaurants()
    }

    private fun fetchRestaurants() {
        viewModelScope.launch {
            runCatching {
                val restaurants = matsosikRepository.getRestaurants()
                _restaurants.emit(restaurants)
            }.onFailure { throwable: Throwable ->
                Timber.e(throwable)
            }
        }
    }
}