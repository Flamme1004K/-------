package com.example.board.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewBoardRepository : JpaRepository<ReviewBoardEntity, Long> {

    fun findByOrderNoAndMemberNo(orderNo:Long, memberNo:Long) : ReviewBoardEntity?
}
