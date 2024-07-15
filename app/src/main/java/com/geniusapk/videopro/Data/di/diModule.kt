package com.geniusapk.videopro.Data.di

import com.geniusapk.videopro.Data.RepoImpl.VideoAppRepoImpl
import com.geniusapk.videopro.Domain.Repo.VideoAppRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object diModule {
    @Provides
    fun provideRepo(): VideoAppRepo {
        return VideoAppRepoImpl()
    }

}