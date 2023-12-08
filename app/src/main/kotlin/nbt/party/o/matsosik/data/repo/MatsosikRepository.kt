package nbt.party.o.matsosik.data.repo

import nbt.party.o.matsosik.data.RestaurantData

interface MatsosikRepository {
    suspend fun getRestaurants(): List<RestaurantData>
}