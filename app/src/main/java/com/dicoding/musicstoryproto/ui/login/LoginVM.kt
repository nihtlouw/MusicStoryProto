package com.dicoding.musicstoryproto.ui.login

import androidx.lifecycle.ViewModel
import com.dicoding.musicstoryproto.data.StoryRepository

class LoginVM(private val storyRepository: StoryRepository): ViewModel() {
    fun postLogin(email: String, password: String) = storyRepository.login(email, password)
}