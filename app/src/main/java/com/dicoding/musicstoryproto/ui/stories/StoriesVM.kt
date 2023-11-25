package com.dicoding.musicstoryproto.ui.stories

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dicoding.musicstoryproto.data.StoryRepository
import com.dicoding.musicstoryproto.response.Story

class StoriesVM(repo: StoryRepository): ViewModel() {
    val getListStory: LiveData<PagingData<Story>> =
        repo.getListStories().cachedIn(viewModelScope)
}