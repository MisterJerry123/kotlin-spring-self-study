package com.misterjerry.spring_study.repository

import com.misterjerry.spring_study.domain.Member

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Long): Member?
    fun findByName(name:String): Member?
    fun findAll():List<Member>




}