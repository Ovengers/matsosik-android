package nbt.party.o.matsosik.data.fake

import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RestaurantData

class FakeMatsosikDataSource : MatsosikDataSource {
    private val mockRestaurants = listOf(
        RestaurantData(0, "양포식당", "서울특별시 서초구 서초동 1502-5", 37.4894743, 127.0068655),
        RestaurantData(
            1,
            "샤오짠",
            "아파트 서초구 상가 반포대로21길 27 서울특별시 화원그랑빌 1층 108호",
            37.4870838,
            127.0082748
        )
    )

    override suspend fun getRestaurants(): List<RestaurantData> {
        return mockRestaurants
    }
}