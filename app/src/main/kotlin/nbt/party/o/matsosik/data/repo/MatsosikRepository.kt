package nbt.party.o.matsosik.data.repo

import android.net.Uri
import nbt.party.o.matsosik.data.RequestReviewData
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.ReviewData

interface MatsosikRepository {
    suspend fun getRestaurants(): List<RestaurantData>
    suspend fun getRestaurant(restaurantId: Long): RestaurantData
    suspend fun createReview(
        images: List<Uri>,
        requestReviewData: RequestReviewData
    ): ReviewData
}