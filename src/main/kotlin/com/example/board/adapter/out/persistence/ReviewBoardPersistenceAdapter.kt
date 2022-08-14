package com.example.board.adapter.out.persistence

import com.example.board.application.port.out.LoadReviewBoard
import com.example.board.application.port.out.SaveReviewBoard
import com.example.board.domain.Board
import com.example.board.domain.Member
import com.example.board.domain.Order
import com.example.board.domain.Visibility
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ReviewBoardPersistenceAdapter(private val reviewBoardRepository: ReviewBoardRepository) : SaveReviewBoard,
    LoadReviewBoard {

    @Transactional(readOnly = true)
    override fun load(orderNo: Long, memberNo: Long): Board? {
        return reviewBoardRepository.findByOrderNoAndMemberNo(orderNo, memberNo)?.let {
            Board(
                it.no,
                it.subject,
                it.contents,
                Visibility.valueOf(it.visibility.name),
                Member(it.no),
                Order(it.orderNo)
            )
        }
    }

    @Transactional
    override fun save(orderNo: Long, memberNo: Long): Board {
        return reviewBoardRepository.save(
            ReviewBoardEntity(
                memberNo = memberNo,
                orderNo = orderNo,
            )
        ).let {
            Board(
                it.no,
                it.subject,
                it.contents,
                Visibility.valueOf(it.visibility.name),
                Member(it.no),
                Order(it.orderNo)
            )
        }
    }
}