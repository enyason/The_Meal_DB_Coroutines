package com.sanmidev.themealdbcoroutines.di


import com.sanmidev.themealdbcoroutines.data.MealsDbService
import com.sanmidev.themealdbcoroutines.data.repo.MealsDBRepository
import com.sanmidev.themealdbcoroutines.data.repo.MealsRepository
import com.sanmidev.themealdbcoroutines.data.response.mapper.MealsDbMapper
import com.sanmidev.themealdbcoroutines.utils.CoilImageLoader
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesMealDbMapper() : MealsDbMapper {
        return MealsDbMapper
    }

    @Provides
    @Singleton
    fun providesMealsDBRepository(mealsDbService: MealsDbService, mealsDBMapper : MealsDbMapper) : MealsDBRepository{
        return MealsDBRepository(mealsDbService, mealsDBMapper)
    }

    @Provides
    @Singleton
    fun providesImageLoader() : CoilImageLoader {
        return CoilImageLoader
    }


    @Module
    @InstallIn(ApplicationComponent::class)
    abstract class BindsModule{

        @Binds
        @Singleton
        abstract fun bindsMealsRepository(mealsDBRepository: MealsDBRepository) : MealsRepository

        @Binds
        @Singleton
        abstract fun bindsImageLoader(coilImageLoader: CoilImageLoader) : CoilImageLoader
    }
}