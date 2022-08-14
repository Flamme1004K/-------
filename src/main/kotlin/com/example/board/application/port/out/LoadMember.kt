package com.example.board.application.port.out

import com.example.board.domain.Member

interface LoadMember {
    fun load(memberNo: Long): Member
}