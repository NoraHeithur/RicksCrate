package com.nora.rickscrate.di

import com.nora.rickscrate.data.repository.character.CharacterDetailsRepositoryImpl
import com.nora.rickscrate.domain.repository.character.CharacterRepository
import com.nora.rickscrate.data.repository.character.CharacterRepositoryImpl
import com.nora.rickscrate.data.repository.episode.EpisodeRepositoryImpl
import com.nora.rickscrate.data.repository.location.LocationRepositoryImpl
import com.nora.rickscrate.domain.repository.character.CharacterDetailsRepository
import com.nora.rickscrate.domain.repository.episode.EpisodeRepository
import com.nora.rickscrate.domain.repository.location.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    abstract fun bindCharacterDetailsRepository(
        characterDetailsRepositoryImpl: CharacterDetailsRepositoryImpl
    ): CharacterDetailsRepository

    @Binds
    abstract fun bindEpisodeRepository(
        episodeRepositoryImpl: EpisodeRepositoryImpl
    ): EpisodeRepository

    @Binds
    abstract fun bindLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository
}