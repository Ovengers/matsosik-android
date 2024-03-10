@file:Suppress("SpellCheckingInspection")

package nbt.party.o.matsosik.data

import android.net.Uri

interface MatsosikDataSource {
    suspend fun getRestaurants(): List<RestaurantData>
    suspend fun getRestaurant(restaurantId: Long): RestaurantData
    suspend fun createReview(
        images: List<Uri>,
        requestReviewData: RequestReviewData
    ): ReviewData
}