package nbt.party.o.matsosik.data

import androidx.room.Entity
import androidx.room.PrimaryKey


internal const val RESTAURANT_TABLE_NAME = "restaurants"
/**
 * 음식점 정보 Data Class
 */
@Entity(RESTAURANT_TABLE_NAME)
data class RestaurantModel(
    @PrimaryKey(autoGenerate = true)
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