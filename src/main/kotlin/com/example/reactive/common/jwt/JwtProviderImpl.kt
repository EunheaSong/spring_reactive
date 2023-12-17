package com.example.reactive.common.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct

@Component
@PropertySource("classpath:application-secret.properties")
class JwtProviderImpl {

    @Value("\${jwt.secretKey}")
    val key = ""

    @Value("\${jwt.validTime}")
    val time = 0

    @PostConstruct
    protected fun init() {
        secretKey = key
        validTime = time
    }

    companion object {
        var secretKey = ""
        var validTime = 0

        fun create(memberId: String): String {
            val now = Date()
            return Jwts.builder()
                .claim("userInfo", createClaims(memberId))
                .setIssuedAt(now)
                .setExpiration(Date(now.time + validTime))
                .signWith(getSignKey(secretKey))
                .compact()
        }

        private fun createClaims(memberId: String): Map<String, String> {
            val claims = mutableMapOf<String, String>()
            claims["id"] = memberId
            return claims
        }

        private fun getSignKey(secretKey: String) = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    }
}