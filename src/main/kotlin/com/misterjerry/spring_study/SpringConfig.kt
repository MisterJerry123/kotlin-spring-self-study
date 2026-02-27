package com.misterjerry.spring_study

import com.misterjerry.spring_study.repository.MemberRepository
import com.misterjerry.spring_study.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringConfig(
    private val springDataJpaMemberRepository: MemberRepository
){


    @Bean
    fun memberService(): MemberService{
        return MemberService(springDataJpaMemberRepository)
    }


//    @Bean
//    fun memberRepository(): MemberRepository{
//        return RemoteJpaMemberRepositoryImpl(entityManager)
//    }
}