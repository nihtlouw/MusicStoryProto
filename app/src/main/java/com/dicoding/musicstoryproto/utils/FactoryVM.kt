package com.dicoding.musicstoryproto.utils

import com.dicoding.musicstoryproto.data.StoryRepository
import com.dicoding.musicstoryproto.ui.stories.StoriesVM
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.musicstoryproto.inject.Injection
import com.dicoding.musicstoryproto.ui.createstory.CreateStoryVM
import com.dicoding.musicstoryproto.ui.login.LoginVM
import com.dicoding.musicstoryproto.ui.register.RegisterVM

class FactoryVM private constructor(private val repo: StoryRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StoriesVM::class.java)) {
            return StoriesVM(repo) as T
        }
        if (modelClass.isAssignableFrom(LoginVM::class.java)) {
            return LoginVM(repo) as T
        }
        if (modelClass.isAssignableFrom(RegisterVM::class.java)) {
            return RegisterVM(repo) as T
        }
        if (modelClass.isAssignableFrom(CreateStoryVM::class.java)) {
            return CreateStoryVM(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: FactoryVM? = null
        fun getInstance(context: Context): FactoryVM {
            return instance ?: synchronized(this) {
                instance ?: FactoryVM(Injection.provideRepository(context))
            }.also { instance = it }
        }
    }
}