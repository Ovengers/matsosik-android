package nbt.party.o.matsosik.data.api

import nbt.party.o.matsosik.data.ResponseRestaurantData
import retrofit2.http.GET

interface RestaurantApi {
    @GET("/api/v1/restaurants")
    suspend fun getRestaurants(): ResponseRestaurantData
}