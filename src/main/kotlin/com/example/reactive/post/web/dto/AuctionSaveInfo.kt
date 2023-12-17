package com.example.reactive.post.web.dto

data class AuctionSaveInfo(
    val registrantId: String,
    val title: String,
    val contents: String,
    val bookId: String,
)