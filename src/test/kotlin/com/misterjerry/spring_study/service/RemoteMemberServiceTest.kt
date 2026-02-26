package com.misterjerry.spring_study.service

import com.misterjerry.spring_study.domain.Member
import com.misterjerry.spring_study.repository.MemberRepository
import com.misterjerry.spring_study.repository.RemoteMemberRepositoryImpl
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@SpringBootTest
@Transactional
class RemoteMemberServiceTest {
    @Autowired
    lateinit var memberRepository: MemberRepository
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

        assertEquals(memberService.findOne(member1.id).name,member1.name)
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