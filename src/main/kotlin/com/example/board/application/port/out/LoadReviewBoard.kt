package com.example.board.application.port.out

import com.example.board.domain.Board

interface LoadReviewBoard {
    fun load(orderNo: Long, memberNo: Long): Board?
}