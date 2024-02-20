package nbt.party.o.matsosik.data.fake

import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.RequestReviewData
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.ReviewData

class FakeMatsosikDataSource : MatsosikDataSource {
    private val mockRestaurants = listOf(
        RestaurantData(
            187,
            "샤브샤브 (롯데마트)",
            "서울 서초구 서초대로38길 12 롯데마트 내",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzExMTdfMjUz%2FMDAxNzAwMTkyNTYxNjUy.-FS-UOMm61Q8veLrEMIvQHVrgQzd9IxvbEQQEbNh50Ig.h5S23QDcFtY8hQWGHG2Um4sAUTRDA-oiX0Sq0tJLxM8g.JPEG.a_zum_koya%2F20231117%25A3%25DF114135.jpg&type=sc960_832",
            37.4902536,
            127.0061464
        ),

        RestaurantData(
            188,
            "우야 (장어덮밥)",
            "서울특별시 서초구 서초대로42길 41 2층",
            "https://d12zq4w4guyljn.cloudfront.net/750_750_20220929055414_photo2_OQsttOHxMH8D.jpg",
            37.4902836,
            127.0093969
        )
    )

    private val mockRestaurant: RestaurantData = RestaurantData(
        187,
        "샤브샤브 (롯데마트)",
        "서울 서초구 서초대로38길 12 롯데마트 내",
        "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzExMTdfMjUz%2FMDAxNzAwMTkyNTYxNjUy.-FS-UOMm61Q8veLrEMIvQHVrgQzd9IxvbEQQEbNh50Ig.h5S23QDcFtY8hQWGHG2Um4sAUTRDA-oiX0Sq0tJLxM8g.JPEG.a_zum_koya%2F20231117%25A3%25DF114135.jpg&type=sc960_832",
        37.4902536,
        127.0061464
    )

    override suspend fun getRestaurants(): List<RestaurantData> {
        return mockRestaurants
    }

    override suspend fun getRestaurant(restaurantId: Long): RestaurantData {
        return mockRestaurant
    }

    override suspend fun createReview(requestReviewData: RequestReviewData): ReviewData {
        return ReviewData(
            title = "테스트 ",
            content = "테스트 리뷰 내용",
            score = 4,
            uploadedImages = listOf(),
            createdAt = "2024-02-18T20:59:45.387079"
        )
    }
}