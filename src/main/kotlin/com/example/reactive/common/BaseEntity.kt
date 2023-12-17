package com.example.reactive.common

import com.example.reactive.common.Utils.customUUID
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @Id
    @Column(length = 15)
    val id = customUUID()

    @Column(nullable = false)
    val isDeleted = false

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createDateTime = LocalDateTime.now()
        protected set

    @LastModifiedDate
    @Column(nullable = false)
    var updateDateTime = LocalDateTime.now()
        protected set
}