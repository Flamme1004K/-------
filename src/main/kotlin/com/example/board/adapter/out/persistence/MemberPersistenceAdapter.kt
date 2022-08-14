package com.example.board.adapter.out.persistence

import com.example.board.application.port.out.LoadMember
import com.example.board.domain.Member
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberPersistenceAdapter(private val memberRepository: MemberRepository) : LoadMember {

    @Transactional(readOnly = true)
    override fun load(memberNo: Long): Member {
        val memberEntity = memberRepository.findByIdOrNull(memberNo) ?: throw IllegalArgumentException("회원이 존재하지 않습니다.")
        return Member(memberEntity.no, memberEntity.name)
    }
}