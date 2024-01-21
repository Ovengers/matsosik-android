package nbt.party.o.matsosik.data.local

import kotlinx.coroutines.flow.Flow
import nbt.party.o.matsosik.data.RestaurantData

interface RestaurantLocalDataSource {
    fun getRestaurants(): Flow<List<RestaurantData>>
}