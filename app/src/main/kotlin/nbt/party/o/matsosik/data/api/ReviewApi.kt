package nbt.party.o.matsosik.data.api

import nbt.party.o.matsosik.data.ReviewData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface ReviewApi {
    @Multipart
    @POST("/api/v1/reviews")
    suspend fun createReview(
        @Part
        reviewImages: List<MultipartBody.Part?>,
        @PartMap
        requestReview: Map<String, RequestBody>
    ): ReviewData
}