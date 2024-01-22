package model

import kotlinx.serialization.Serializable

@Serializable
data class Bird(
    val category: String? = null,
    val path: String? = null,
    val author: String? = null
)