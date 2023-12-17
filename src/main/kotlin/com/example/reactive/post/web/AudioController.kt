package com.example.reactive.post.web

import com.example.reactive.post.application.AudioService
import com.example.reactive.post.web.dto.AuctionSaveInfo
import com.example.reactive.post.web.dto.AudioBookInfo
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/post")
class AudioController(
    private val audioService: AudioService
) {
    @GetMapping("/{id}")
    fun getBook(@PathVariable id: String): Mono<AudioBookInfo> = audioService.get(id)

    @PostMapping("")
    fun saveAudioBook(
        @RequestBody req: AuctionSaveInfo,
        @RequestParam(value = "audioFile", required = true) audioFile: MultipartFile
    ): Mono<String> = audioService.save(req, audioFile)

    @PutMapping("/{id}")
    fun modifyAudioBook(
        @PathVariable id: String,
        @RequestBody audioInfo: AuctionSaveInfo,
        @RequestParam(value = "audioFile", required = false) audioFile: MultipartFile
    ): Mono<String> = audioService.modify(id, audioInfo, audioFile)

    @DeleteMapping("/{id}")
    fun removeAudioBook(@PathVariable id: String) = audioService.remove(id)
}