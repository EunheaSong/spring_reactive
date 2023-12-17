package com.example.reactive.post.application

import com.example.reactive.post.web.dto.AudioBookInfo
import org.springframework.stereotype.Component

@Component
interface AudioReadPort {
    fun getAudioInfoById(id: String): AudioBookInfo
}