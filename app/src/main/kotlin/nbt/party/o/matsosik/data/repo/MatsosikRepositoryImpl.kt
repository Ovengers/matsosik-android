package nbt.party.o.matsosik.data.repo

import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RestaurantData

class MatsosikRepositoryImpl constructor(
    private val matsosikDataSource: MatsosikDataSource
) : MatsosikRepository {
    override suspend fun getRestaurants(): List<RestaurantData> {
        return matsosikDataSource.getRestaurants()
    }
}