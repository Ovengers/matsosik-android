package nbt.party.o.matsosik.data.fake

import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RestaurantData

class FakeMatsosikDataSource : MatsosikDataSource {
    private val mockRestaurants = listOf(
        RestaurantData(0, "양포식당", "address", 37.490269801827, 127.0009402539781)
    )

    override suspend fun getRestaurants(): List<RestaurantData> {
        return mockRestaurants
    }
}