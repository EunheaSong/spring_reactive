package com.example.reactive.common

import java.util.*

object Utils {
    fun customUUID(): String {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 15)
    }
}