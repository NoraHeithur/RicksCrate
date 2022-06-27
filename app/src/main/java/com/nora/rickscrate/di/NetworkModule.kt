package com.nora.rickscrate.di

import android.content.Context
import com.nora.rickscrate.data.network.RnMCharacterService
import com.nora.rickscrate.data.network.RnMEpisodeService
import com.nora.rickscrate.data.network.RnMLocationService
import com.nora.rickscrate.data.util.NetworkStateInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            interceptors().add(httpLoggingInterceptor)
            interceptors().add(NetworkStateInterceptor(context))
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl("https://rickandmortyapi.com/api/")
            addConverterFactory(MoshiConverterFactory.create(moshi))
            client(client)
        }.build()
    }

    @Provides
    @Singleton
    fun provideCharacterService(retrofit: Retrofit): RnMCharacterService {
        return retrofit.create(RnMCharacterService::class.java)
    }

    @Provides
    @Singleton
    fun provideEpisodeService(retrofit: Retrofit): RnMEpisodeService {
        return retrofit.create(RnMEpisodeService::class.java)
    }

    @Provides
    @Singleton
    fun provideLocationService(retrofit: Retrofit): RnMLocationService {
        return retrofit.create(RnMLocationService::class.java)
    }
}