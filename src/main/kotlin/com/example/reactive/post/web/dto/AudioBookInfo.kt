package com.example.reactive.post.web.dto

import com.example.reactive.post.infrastructure.AudioFilePathOnly

data class AudioBookInfo(
    val detailInfo: AudioBookDetailInfo,
    val audioFilePath: List<AudioFilePathOnly>
)