package com.example.reactive.post.application

import org.springframework.web.multipart.MultipartFile
import reactor.core.publisher.Mono

interface FileService {
    fun upload(file: MultipartFile): Mono<String>
}