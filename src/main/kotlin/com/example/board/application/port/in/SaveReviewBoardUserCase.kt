package com.example.board.application.port.`in`

import com.example.board.domain.Board

interface SaveReviewBoardUserCase {
    fun save(memberNo: Long, orderNo: Long): Board
}