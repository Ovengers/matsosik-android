@file:Suppress("SpellCheckingInspection")

package nbt.party.o.matsosik.data

interface MatsosikDataSource {
    suspend fun getRestaurants(): List<RestaurantData>
}