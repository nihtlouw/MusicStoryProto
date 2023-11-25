package com.dicoding.musicstoryproto.ui.detailstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dicoding.musicstoryproto.R
import com.dicoding.musicstoryproto.constants.Constants
import com.dicoding.musicstoryproto.databinding.ActivityDetailStoryBinding
import com.dicoding.musicstoryproto.response.Story
import com.dicoding.musicstoryproto.utils.withDateFormat

class DetailStoryAct : AppCompatActivity() {
    private lateinit var binding: ActivityDetailStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailStory = intent.getParcelableExtra<Story>(Constants.DETAIL_STORY) as Story

        setupToolBar()
        setupUi(detailStory)
    }

    private fun setupToolBar() {
        title = resources.getString(R.string.detail_story)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    private fun setupUi(detailStory: Story) {
        Glide.with(this@DetailStoryAct)
            .load(detailStory.photoUrl)
            .fitCenter()
            .into(binding.storyImageView)

        detailStory.apply {
            binding.nameTextView.text = name
            binding.descriptionTextView.text = description
            binding.dateTextView.text = createdAt.withDateFormat()
        }
    }
}