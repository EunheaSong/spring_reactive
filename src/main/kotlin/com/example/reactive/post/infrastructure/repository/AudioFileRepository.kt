package com.example.reactive.post.infrastructure.repository

import com.example.reactive.post.domain.AudioBook
import com.example.reactive.post.domain.AudioFile
import com.example.reactive.post.infrastructure.AudioFilePathOnly
import org.springframework.data.jpa.repository.JpaRepository

interface AudioFileRepository: JpaRepository<AudioFile, String> {
    fun findAllByAudioBook(audioBook: AudioBook): List<AudioFilePathOnly>
}