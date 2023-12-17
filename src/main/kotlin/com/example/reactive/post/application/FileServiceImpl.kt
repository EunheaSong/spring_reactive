package com.example.reactive.post.application

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono
import java.io.File


@Service
class FileServiceImpl: FileService {
    @Value("\${file.path}")
    lateinit var path: String

    override fun upload(file: MultipartFile): Mono<String> {
        return Mono.fromRunnable {
            val fileName = "$path/${file.originalFilename}"
            file.transferTo(File(fileName))
            fileName
        }
    }
}