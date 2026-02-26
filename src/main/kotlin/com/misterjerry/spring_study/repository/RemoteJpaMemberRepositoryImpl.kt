package com.misterjerry.spring_study.repository

import com.misterjerry.spring_study.domain.Member
import jakarta.persistence.EntityManager

class RemoteJpaMemberRepositoryImpl(
    private val entityManager: EntityManager
) : MemberRepository {


    override fun save(member: Member) {
        entityManager.persist(member)
    }

    override fun findById(id: Long): Member? {
        return entityManager.find(Member::class.java, id)
    }

    override fun findByName(name: String): Member? {
        return entityManager.createQuery(
            "select m from Member m where m.name = :name",
            Member::class.java
        ).setParameter("name", name).resultList.firstOrNull()
    }

    override fun findAll(): List<Member> {
        return entityManager.createQuery("select m from Member m", Member::class.java).resultList
    }
}