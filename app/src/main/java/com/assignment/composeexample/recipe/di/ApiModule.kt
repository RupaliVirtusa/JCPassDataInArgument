package com.assignment.composeexample.recipe.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

  /*  @Provides
    fun provideRetrofit(): Retrofit {

    }*/
}