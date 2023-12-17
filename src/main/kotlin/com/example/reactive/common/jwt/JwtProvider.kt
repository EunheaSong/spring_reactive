package com.example.reactive.common.jwt

interface JwtProvider {
    fun create(): String
}