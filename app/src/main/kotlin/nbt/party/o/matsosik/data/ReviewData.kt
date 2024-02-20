package nbt.party.o.matsosik.data

import kotlinx.serialization.Serializable


//"title" : "테스트 ",
//"content" : "테스트 리뷰 내용",
//"score" : 4,
//"uploadedImages" : [ "https://matsosik-development-bucket.s3.ap-northeast-2.amazonaws.com/uploads/240218_205945_test_img1.png", "https://matsosik-development-bucket.s3.ap-northeast-2.amazonaws.com/uploads/240218_205945_test_img2.jpg" ],
//"createdAt" : "2024-02-18T20:59:45.387079"

@Serializable
data class ReviewData(
    val title: String,
    val content: String,
    val score: Int,
    val uploadedImages: List<String>,
    val createdAt: String
)