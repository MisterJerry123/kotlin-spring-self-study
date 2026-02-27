package com.misterjerry.spring_study.repository

import com.misterjerry.spring_study.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaMemberRepository: JpaRepository<Member, Long>, MemberRepository {
    override fun findByName(name: String): Member?
}