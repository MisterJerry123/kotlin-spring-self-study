package com.misterjerry.spring_study.repository

import com.misterjerry.spring_study.domain.Member

class MemberRepositoryImpl : MemberRepository {

    val store : MutableMap<Long, Member> = HashMap()
    var sequence : Long = 0L


    override fun save(member: Member): Member {
        store[++sequence] = member
        return member

    }

    override fun findById(id: Long): Member? {
        return store.values.find { it.id==id }
    }

    override fun findByName(name: String): Member? {
        return store.values.find { it.name==name }

    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clear(){
        store.clear()
    }
}