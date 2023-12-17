package com.example.reactive.post.application

import com.example.reactive.post.application.dto.AudioFileInfo
import com.example.reactive.post.web.dto.AuctionSaveInfo

interface AudioUpdatePort {
    fun saveAudioBookAndFile(audioInfo: AuctionSaveInfo, audioFileInfo: AudioFileInfo)
}