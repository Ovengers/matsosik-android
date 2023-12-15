package nbt.party.o.matsosik.data

/**
 * 음식점 정보 Data Class
 */
data class RestaurantData(
    val id: Long,               // 음식점 ID
    val name: String,           // 음식점 이름
    val address: String,        // 음식점 주소
    val latitude: Double,       // 음식점 위도
    val longitude: Double       // 음식점 경도
) {
    companion object {
        val EMPTY = RestaurantData(-1, "", "", 0.0, 0.0)
    }
}