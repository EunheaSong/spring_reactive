package com.example.reactive.post.domain

import com.example.reactive.common.BaseEntity
import javax.persistence.*

@Entity
class AudioFile(
    @Column(nullable = false)
    val filePath: String,
    @Column(nullable = false)
    val originName: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audio_book_id")
    val audioBook: AudioBook
): BaseEntity()