package com.net.core.network.retrofit

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    val data: T
)
