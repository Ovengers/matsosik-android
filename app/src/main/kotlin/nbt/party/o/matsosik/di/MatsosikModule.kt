package nbt.party.o.matsosik.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nbt.party.o.matsosik.data.MatsosikDataSource
import nbt.party.o.matsosik.data.fake.FakeMatsosikDataSource
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
object MatsosikModule {

    @FakeMatsosik
    @Provides
    fun provideMatsosikDataSource(): MatsosikDataSource {
        return FakeMatsosikDataSource()

    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class FakeMatsosik