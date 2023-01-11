package com.services.account.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(value = "account")
data class Account  @JvmOverloads constructor(
    @Id
    val id: String?=null,
    val username: String,
    val email: String,
    val password: String
)
