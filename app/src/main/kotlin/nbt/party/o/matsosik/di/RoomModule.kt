package nbt.party.o.matsosik.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import nbt.party.o.matsosik.data.local.db.RestaurantDao
import nbt.party.o.matsosik.data.local.db.RestaurantDatabase
import javax.inject.Singleton

private const val RESTAURANT_DB_NAME = "restaurant.db"

@Module
@InstallIn(SingletonComponent::class)
object RestaurantRoomModule {


    @Provides
    @Singleton
    fun provideRestaurantDatabase(@ApplicationContext context: Context): RestaurantDatabase =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, RESTAURANT_DB_NAME).build()

    @Provides
    @Singleton
    fun provideRestaurantDao(restaurantDatabase: RestaurantDatabase): RestaurantDao =
        restaurantDatabase.restaurantDao()

}