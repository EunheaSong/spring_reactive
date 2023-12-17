package com.example.reactive.post.infrastructure.mapper

import com.example.reactive.post.application.dto.AudioFileInfo
import com.example.reactive.post.domain.AudioBook
import com.example.reactive.post.domain.AudioFile
import org.springframework.stereotype.Component

@Component
class AudioFileMapper {
    fun mapToEntity(audioFileInfo: AudioFileInfo, audioBook: AudioBook): AudioFile {
        return AudioFile(
            filePath = audioFileInfo.filePath,
            originName = audioFileInfo.originName,
            audioBook = audioBook
        )
    }
}