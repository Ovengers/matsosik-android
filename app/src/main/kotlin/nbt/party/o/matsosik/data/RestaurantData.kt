package nbt.party.o.matsosik.data

import kotlinx.serialization.Serializable

@Serializable
data class ResponseRestaurantData(
    val restaurants: List<RestaurantData>
)

/**
 * 음식점 정보 Data Class
 */
@Serializable
data class RestaurantData(
    val id: Long,               // 음식점 ID
    val displayName: String,    // 음식점 이름
    val address: String,        // 음식점 주소
    val thumbnail: String,      // 음식점 이미지
    val latitude: Double,       // 음식점 위도
    val longitude: Double       // 음식점 경도
) {
    companion object {
        val EMPTY = RestaurantData(-1, "", "", "", 0.0, 0.0)
    }
}