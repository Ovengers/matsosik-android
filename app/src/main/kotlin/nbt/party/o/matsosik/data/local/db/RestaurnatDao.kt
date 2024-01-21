package nbt.party.o.matsosik.data.local.db

import androidx.room.Dao
import androidx.room.Query
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.data.RESTAURANT_TABLE_NAME


@Dao
interface RestaurantDao {
    @Query("SELECT * FROM $RESTAURANT_TABLE_NAME")
    fun getRestaurants(): List<RestaurantData>
}