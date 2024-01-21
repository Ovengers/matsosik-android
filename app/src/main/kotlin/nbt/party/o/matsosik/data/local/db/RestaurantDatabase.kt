package nbt.party.o.matsosik.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import nbt.party.o.matsosik.data.RestaurantModel

@Database(
    entities = [RestaurantModel::class],
    version = 1,
    exportSchema = true
)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}