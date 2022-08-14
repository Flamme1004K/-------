package com.example.board.adapter.out.persistence

import org.apache.logging.log4j.util.Strings
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ReviewBoardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val no: Long = 0L,
    val memberNo: Long,
    val orderNo: Long,
    val subject: String = Strings.EMPTY,
    val contents: String = Strings.EMPTY,
    @Enumerated(EnumType.STRING)
    val visibility: Visibility = Visibility.DRAFT,
)