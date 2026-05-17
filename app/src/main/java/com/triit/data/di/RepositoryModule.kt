package com.triit.data.di

import android.content.Context
import com.google.ai.client.generativeai.GenerativeModel
import com.triit.data.repository.*
import com.triit.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGenerativeModel(): GenerativeModel {
        return GenerativeModel(
            modelName = "gemini-pro",
            apiKey = "YOUR_GEMINI_API_KEY" // TODO: Add to BuildConfig
        )
    }

    @Provides
    @Singleton
    fun provideSafetyRepository(generativeModel: GenerativeModel): SafetyRepository {
        return SafetyRepositoryImpl(generativeModel)
    }

    @Provides
    @Singleton
    fun provideUserRepository(@ApplicationContext context: Context): UserRepository {
        return UserRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideRideRepository(): RideRepository {
        return RideRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideLocationRepository(@ApplicationContext context: Context): LocationRepository {
        return LocationRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideReviewRepository(): ReviewRepository {
        return ReviewRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCommunityRepository(): CommunityRepository {
        return CommunityRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideSOSRepository(): SOSRepository {
        return SOSRepositoryImpl()
    }
}
