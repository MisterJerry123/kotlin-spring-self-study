package com.misterjerry.spring_study.service

import com.misterjerry.spring_study.domain.Member
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class MemberServiceTest {

    lateinit var  memberService : MemberService
    @Test
    fun join() {
        //given
        val member1 = Member(
            id = 1L,
            name = "홍길동"
        )
        val member2 = Member(
            id = 1L,
            name = "이순신"
        )
        val member3 = Member(
            id = 1L,
            name = "세종대왕"
        )
        //when
        memberService.join(member1)
        memberService.join(member2)
        memberService.join(member3)

        //then

        assertEquals(memberService.findOne(1).name,member1.name)
    }

    @Test
    fun 중복회원_가입안되는지_테스트(){
        //given
        val member1 = Member(1,"spring")
        val member2 = Member(2,"spring")

        //when
        memberService.join(member1)


        //then
        assertThrows(IllegalStateException::class.java) {
            memberService.join(member2)
        }

    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }

}