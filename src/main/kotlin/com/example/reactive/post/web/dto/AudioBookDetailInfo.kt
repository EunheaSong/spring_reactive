package com.example.reactive.post.web.dto

import java.time.LocalDateTime

data class AudioBookDetailInfo(
    val id: String,
    val createDateTime: LocalDateTime,
    val updateDateTime: LocalDateTime,
    val registrantId: String,
    val title: String,
    val contents: String,
)