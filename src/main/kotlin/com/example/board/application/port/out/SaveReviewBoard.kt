package com.example.board.application.port.out

import com.example.board.domain.Board

interface SaveReviewBoard {
    fun save(orderNo: Long, memberNo: Long): Board
}