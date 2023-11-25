package com.dicoding.musicstoryproto.ui.createstory

import androidx.lifecycle.ViewModel
import com.dicoding.musicstoryproto.data.StoryRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class CreateStoryVM(private val storyRepository: StoryRepository): ViewModel() {
    fun postCreateStory(imageFile: MultipartBody.Part, desc: RequestBody, lat: Double, lon: Double) = storyRepository.createStory(imageFile, desc, lat, lon)
}