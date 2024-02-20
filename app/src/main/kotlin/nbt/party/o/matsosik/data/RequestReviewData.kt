package nbt.party.o.matsosik.data

import nbt.party.o.matsosik.di.applicationJsonContentType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

data class RequestReviewData(
    val title: String,
    val content: String,
    val score: Int,
    val restaurantId: Int
)

fun RequestReviewData.toPartMap(): Map<String, RequestBody> {

    // Create RequestBody
    val titleRequestBody = title.toRequestBody(applicationJsonContentType)
    val contentRequestBody = content.toRequestBody(applicationJsonContentType)
    val scoreRequestBody = score.toString().toRequestBody(applicationJsonContentType)
    val restaurantIdRequestBody = restaurantId.toString().toRequestBody(applicationJsonContentType)

    // To HashMap
    return mapOf(
        "title" to titleRequestBody,
        "content" to contentRequestBody,
        "score" to scoreRequestBody,
        "restaurantId" to restaurantIdRequestBody
    )
}