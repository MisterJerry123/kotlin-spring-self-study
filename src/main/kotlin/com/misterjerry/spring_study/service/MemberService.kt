package com.misterjerry.spring_study.service

import com.misterjerry.spring_study.domain.Member
import com.misterjerry.spring_study.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Transactional
open class MemberService(
    private val memberRepository: MemberRepository
) {


    //회원가입
    open fun join(member: Member):Long{
        //같은 회원이 있으면 안됨
        val result = memberRepository.findByName(member.name)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
        val savedMember = memberRepository.save(member)

        println("### DEBUG: savedMember.id = ${savedMember.id}")

        return savedMember.id
    }

    open fun findMembers():List<Member>{
        return memberRepository.findAll()
    }

    open fun findOne(memberId:Long): Member{
        return memberRepository.findById(memberId) ?: Member()
    }
}