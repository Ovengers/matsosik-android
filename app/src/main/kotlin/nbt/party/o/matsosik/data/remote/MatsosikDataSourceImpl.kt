package nbt.party.o.matsosik.data.remote

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RequestReviewData
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.ReviewData
import nbt.party.o.matsosik.data.api.RestaurantApi
import nbt.party.o.matsosik.data.api.ReviewApi
import nbt.party.o.matsosik.data.toPartMap
import nbt.party.o.matsosik.ext.toMultiPart

class MatsosikDataSourceImpl(
    @ApplicationContext private val context: Context,
    private val restaurantApi: RestaurantApi,
    private val reviewApi: ReviewApi
) : MatsosikDataSource {
    override suspend fun getRestaurants(): List<RestaurantData> {
        return restaurantApi.getRestaurants().restaurants
    }

    override suspend fun getRestaurant(restaurantId: Long): RestaurantData {
        TODO("Not yet implemented")
    }

    override suspend fun createReview(
        images: List<Uri>,
        requestReviewData: RequestReviewData
    ): ReviewData {

        val reviewImages = images.map { uri: Uri ->
            uri.toMultiPart("", context.contentResolver)
        }
        return reviewApi.createReview(reviewImages, requestReviewData.toPartMap())
    }
}