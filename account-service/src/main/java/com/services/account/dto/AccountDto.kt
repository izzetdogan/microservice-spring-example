package com.services.account.dto

import com.services.account.entity.Account

data class AccountDto(
    val id: String?,
    val username: String,
    val email: String,
    val password: String
)
{
    companion object {
        @JvmStatic
        fun convert(from: Account): AccountDto {
            return AccountDto(
                from.id,
                from.username,
                from.email,
                from.password)
        }
    }

}
