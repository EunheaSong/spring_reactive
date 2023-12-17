package com.example.reactive.common
import java.lang.RuntimeException

class NotFoundResourceException: RuntimeException {
    constructor(): super()
    constructor(message: String): super(message)
}