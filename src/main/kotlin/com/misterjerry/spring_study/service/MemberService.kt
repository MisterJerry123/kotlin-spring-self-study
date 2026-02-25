package com.misterjerry.spring_study.service

import com.misterjerry.spring_study.domain.Member
import com.misterjerry.spring_study.repository.MemberRepository
import com.misterjerry.spring_study.repository.RemoteMemberRepositoryImpl

class MemberService(
    private val memberRepository: MemberRepository
) {


    //회원가입
    fun join(member: Member){
        //같은 회원이 있으면 안됨
        val result = memberRepository.findByName(member.name)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
        memberRepository.save(member)
    }

    fun findMembers():List<Member>{
        return memberRepository.findAll()
    }

    fun findOne(memberId:Long): Member{
        return memberRepository.findById(memberId) ?: Member()
    }
}