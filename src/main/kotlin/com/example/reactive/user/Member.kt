package com.example.reactive.user

import com.example.reactive.common.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Member(
    @Column(nullable = false)
    val email: String,
    @Column(nullable = false)
    val password: String,
): BaseEntity()