package com.example.reactive.post.application

import com.example.reactive.post.application.dto.AudioFileInfo
import com.example.reactive.post.web.dto.AuctionSaveInfo
import com.example.reactive.post.web.dto.AudioBookInfo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class AudioServiceImpl(
    private val audioReadPort: AudioReadPort,
    private val audioUpdatePort: AudioUpdatePort,
    private val fileService: FileService
) : AudioService {

    private val logger = LoggerFactory.getLogger(AudioServiceImpl::class.java)

    override fun get(id: String): Mono<AudioBookInfo> {
        return Mono.just(audioReadPort.getAudioInfoById(id))
            .doOnError { logger.info(it.stackTraceToString()) }
    }

    override fun save(audioInfo: AuctionSaveInfo, audioFile: MultipartFile): Mono<String> {
        return Mono.fromCallable {
            fileService.upload(audioFile)
        }.map { filePath ->
            logger.info(filePath.toString())
            val audioFileInfo = AudioFileInfo(
                "",
                audioFile.originalFilename ?: LocalDateTime.now().toString()
            )
            audioUpdatePort.saveAudioBookAndFile(audioInfo, audioFileInfo)
        }.then(
            Mono.fromCallable {
                "완료!"
            }
        ).doOnError { logger.info(it.stackTraceToString()) }
    }

    override fun modify(
        id: String,
        audioInfo: AuctionSaveInfo,
        audioFile: MultipartFile?
    ): Mono<String> {
        return Mono.just("")
    }

    override fun remove(id: String) {

    }
}