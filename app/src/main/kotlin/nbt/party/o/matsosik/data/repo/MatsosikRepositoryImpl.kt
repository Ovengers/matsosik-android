package nbt.party.o.matsosik.data.repo

import android.net.Uri
import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RequestReviewData
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.ReviewData
import nbt.party.o.matsosik.di.RemoteMatsosikDataSource

class MatsosikRepositoryImpl(
    @RemoteMatsosikDataSource
    private val matsosikDataSource: MatsosikDataSource
) : MatsosikRepository {
    override suspend fun getRestaurants(): List<RestaurantData> {
        TODO("Not yet implemented")
    }

    override suspend fun getRestaurant(restaurantId: Long): RestaurantData {
        TODO("Not yet implemented")
    }

    override suspend fun createReview(
        images: List<Uri>,
        requestReviewData: RequestReviewData
    ): ReviewData {
        return matsosikDataSource.createReview(images, requestReviewData)
    }
}