package com.example.board.adapter.`in`.web

import com.example.board.application.port.`in`.SaveReviewBoardUserCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class SaveReviewBoardAdapter(private val saveBoardUserCase: SaveReviewBoardUserCase) {

    @GetMapping("/review-board")
    fun saveBoard(
        @RequestParam memberNo: Long,
        @RequestParam orderNo: Long
    ): ResponseEntity<Unit> {
        val board = saveBoardUserCase.save(memberNo, orderNo)
        return ResponseEntity.created(URI.create("/review-board" + board.no)).build()
    }
}