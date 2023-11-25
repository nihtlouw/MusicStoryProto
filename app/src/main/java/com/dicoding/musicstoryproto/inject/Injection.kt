package com.dicoding.musicstoryproto.inject

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.dicoding.musicstoryproto.api.ApiConfig
import com.dicoding.musicstoryproto.data.StoryRepository
import com.dicoding.musicstoryproto.preference.LoginPreference

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("storiesin")

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val preferences = LoginPreference(context)
        val apiService = ApiConfig.getApiService()
        return StoryRepository.getInstance(preferences, apiService)
    }
}