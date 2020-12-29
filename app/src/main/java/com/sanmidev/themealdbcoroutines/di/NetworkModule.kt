package com.sanmidev.themealdbcoroutines.di

import com.sanmidev.themealdbcoroutines.BuildConfig
import com.sanmidev.themealdbcoroutines.data.MealsDbService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesOkhttpClient(okHttpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(okHttpLoggingInterceptor)
        return client.build()
    }

    @Singleton
    @Provides
    fun providesOkHttpLogger(): HttpLoggingInterceptor {
        val okhttpLogger = HttpLoggingInterceptor()
        okhttpLogger.setLevel(HttpLoggingInterceptor.Level.BODY)
        return okhttpLogger
    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
        return retrofit.addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun providesMealsDbService(retrofit: Retrofit) : MealsDbService{
        return retrofit.create(MealsDbService::class.java)
    }

}