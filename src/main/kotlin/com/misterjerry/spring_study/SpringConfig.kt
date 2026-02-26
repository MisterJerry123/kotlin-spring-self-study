package com.misterjerry.spring_study

import com.misterjerry.spring_study.repository.MemberRepository
import com.misterjerry.spring_study.repository.RemoteJpaMemberRepositoryImpl
import com.misterjerry.spring_study.repository.RemoteMemberRepositoryImpl
import com.misterjerry.spring_study.service.MemberService
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class SpringConfig(
    @Autowired private val entityManager: EntityManager
){


    @Bean
    fun memberService(): MemberService{
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository{
        return RemoteJpaMemberRepositoryImpl(entityManager)
    }
}