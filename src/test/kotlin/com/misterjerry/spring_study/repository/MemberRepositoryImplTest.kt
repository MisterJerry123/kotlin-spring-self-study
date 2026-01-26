package com.misterjerry.spring_study.repository

import com.misterjerry.spring_study.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MemberRepositoryImplTest {

    val memberRepositoryImpl = MemberRepositoryImpl()

    @AfterEach
    fun clear (){
        memberRepositoryImpl.clear()
    }

    @Test
    fun getStore() {
    }

    @Test
    fun getSequence() {
    }

    @Test
    fun setSequence() {
    }

    @Test
    fun `멤버가 잘 저장되면 이름으로 검색이 가능하다`() {
        val member = Member(name = "spring")
        memberRepositoryImpl.save(member)

        val result = memberRepositoryImpl.findByName("spring")

        assertEquals(result,member)

    }

    @Test
    fun findById() {
    }

    @Test
    fun findByName() {
    }

    @Test
    fun findAll() {
    }





}