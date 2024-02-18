package nbt.party.o.matsosik.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    private const val BASE_URL = ""
    private val contentType = "application/json".toMediaType()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
                .addConverterFactory(Json.asConverterFactory(contentType))
        }.build()
    }
}