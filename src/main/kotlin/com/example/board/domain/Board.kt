package com.example.board.domain

class Board(
    val no: Long = 0L,
    val subject: String,
    val contents: String,
    val visibility: Visibility,
    val member: Member,
    val order: Order
)
