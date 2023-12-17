package com.example.reactive.post.application

import com.example.reactive.post.web.dto.AuctionSaveInfo
import com.example.reactive.post.web.dto.AudioBookInfo
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono

interface AudioService {
    fun get(id: String): Mono<AudioBookInfo>
    fun save(audioInfo: AuctionSaveInfo, audioFile: MultipartFile): Mono<String>
    fun modify(
        id: String,
        audioInfo: AuctionSaveInfo,
        audioFile: MultipartFile?
    ): Mono<String>
    fun remove(id: String)
}