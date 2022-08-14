package com.example.board.application.service

import com.example.board.application.port.`in`.SaveReviewBoardUserCase
import com.example.board.application.port.out.LoadReviewBoard
import com.example.board.application.port.out.LoadMember
import com.example.board.application.port.out.SaveReviewBoard
import com.example.board.domain.Board
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaveReviewBoardService(
    private val loadMember: LoadMember,
    private val loadBoard: LoadReviewBoard,
    private val saveBoard: SaveReviewBoard
) : SaveReviewBoardUserCase {

    @Transactional
    override fun save(memberNo: Long, orderNo: Long): Board {
        val member = loadMember.load(memberNo)
        return loadBoard.load(orderNo, member.no) ?: saveBoard.save(orderNo, member.no)
    }
}
