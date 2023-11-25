package com.dicoding.musicstoryproto.ui.register

import androidx.lifecycle.ViewModel
import com.dicoding.musicstoryproto.data.StoryRepository

class RegisterVM(private val storyRepository: StoryRepository): ViewModel() {
    fun postRegister(name: String, email: String, password: String) = storyRepository.register(name, email, password)
}