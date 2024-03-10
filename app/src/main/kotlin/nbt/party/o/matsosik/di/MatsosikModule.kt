package nbt.party.o.matsosik.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.api.ReviewApi
import nbt.party.o.matsosik.data.fake.FakeMatsosikDataSource
import nbt.party.o.matsosik.data.remote.MatsosikDataSourceImpl
import nbt.party.o.matsosik.data.repo.MatsosikRepository
import nbt.party.o.matsosik.data.repo.MatsosikRepositoryImpl
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MatsosikModule {

    @FakeMatsosik
    @Provides
    @Singleton
    fun provideFakeMatsosikDataSource(): MatsosikDataSource {
        return FakeMatsosikDataSource()
    }

    @RemoteMatsosikDataSource
    @Provides
    @Singleton
    fun provideMatsosikDataSource(
        @ApplicationContext context: Context,
        reviewApi: ReviewApi
    ): MatsosikDataSource {
        return MatsosikDataSourceImpl(context, reviewApi)
    }

    @Provides
    @Singleton
    fun provideMatsosikRepository(
        @FakeMatsosik matsosikDataSource: MatsosikDataSource
    ): MatsosikRepository {
        return MatsosikRepositoryImpl(matsosikDataSource)
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class FakeMatsosik

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RemoteMatsosikDataSource