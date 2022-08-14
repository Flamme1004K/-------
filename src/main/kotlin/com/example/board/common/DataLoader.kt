package com.example.board.common

import com.example.board.adapter.out.persistence.MemberEntity
import com.example.board.adapter.out.persistence.MemberRepository
import org.springframework.stereotype.Component

@Component
class DataLoader(private val memberRepository: MemberRepository) {
    fun loadData() {
        memberRepository.save(MemberEntity(name = "플람"))
    }
}