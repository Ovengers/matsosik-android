package nbt.party.o.matsosik.data.repo

import android.net.Uri
import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RequestReviewData
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.ReviewData

class MatsosikFakeRepositoryImpl(
    private val matsosikDataSource: MatsosikDataSource
) : MatsosikRepository {
    override suspend fun getRestaurants(): List<RestaurantData> {
        return matsosikDataSource.getRestaurants()
    }

    override suspend fun getRestaurant(restaurantId: Long): RestaurantData {
        return matsosikDataSource.getRestaurant(restaurantId)
    }

    override suspend fun createReview(
        images: List<Uri>,
        requestReviewData: RequestReviewData
    ): ReviewData {
        TODO("Not yet implemented")
    }

}