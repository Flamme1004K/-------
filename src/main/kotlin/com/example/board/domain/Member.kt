package com.example.board.domain

import org.apache.logging.log4j.util.Strings

class Member(
    val no: Long,
    val name: String = Strings.EMPTY
)