package com.misterjerry.spring_study.service

import com.misterjerry.spring_study.domain.Member
import com.misterjerry.spring_study.repository.MemberRepository
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class RemoteMemberServiceTest {
    @Autowired
    lateinit var springDataJpaMemberRepository: MemberRepository
    @Autowired
    lateinit var memberService: MemberService


    
    @Test
    fun join() {
        //given
        val member1 = Member(
            name = "홍길동"
        )
        val member2 = Member(
            name = "이순신"
        )
        val member3 = Member(
            name = "세종대왕"
        )
        //when
        memberService.join(member1)
        memberService.join(member2)
        memberService.join(member3)

        //then
        val findMember = memberService.findOne(member1.id)

        assertEquals(member1.name, findMember.name)
    }

    @Test
    fun 중복회원_가입안되는지_테스트(){
        //given
        val member1 = Member(name = "spring")
        val member2 = Member(name = "spring")

        //when
        memberService.join(member1)


        //then
        assertThrows(IllegalStateException::class.java) {
            memberService.join(member2)
        }

    }
}