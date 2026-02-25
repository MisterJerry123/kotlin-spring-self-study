package com.misterjerry.spring_study.repository

import com.misterjerry.spring_study.domain.Member
import org.springframework.jdbc.datasource.DataSourceUtils
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import javax.sql.DataSource

class RemoteMemberRepositoryImpl(
    private val dataSource: DataSource
) : MemberRepository {
    override fun save(member: Member) {
        val sql = "insert into member(name) values(?)"
        var connection: Connection? = null
        var preparedStatement: PreparedStatement? = null
        var resultSet: ResultSet? = null

        try {
            connection = DataSourceUtils.getConnection(dataSource)
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            preparedStatement.setString(1, member.name)
            preparedStatement.executeUpdate()
            resultSet = preparedStatement.generatedKeys
            if(resultSet.next()) {
                member.id = resultSet.getLong(1)
            }
            else{
                throw SQLException("id 조회 실패")
            }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            resultSet?.close()
            preparedStatement?.close()
            DataSourceUtils.releaseConnection(connection,dataSource)

        }

    }

    override fun findById(id: Long): Member? {

        val sql = "select * from member where id = ?"
        var connection: Connection? = null
        var preparedStatement: PreparedStatement? = null
        var resultSet: ResultSet? = null

        try {
            connection = DataSourceUtils.getConnection(dataSource)
            preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setLong(1, id)
            resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                val resultMember = Member(
                    id = resultSet.getLong("id"),
                    name = resultSet.getString("name")
                )
                return resultMember
            } else {
                return null
            }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            resultSet?.close()
            preparedStatement?.close()
            DataSourceUtils.releaseConnection(connection,dataSource)

        }

    }

    override fun findByName(name: String): Member? {

        val sql = "select * from member where name = ?"
        var connection: Connection? = null
        var preparedStatement: PreparedStatement? = null
        var resultSet: ResultSet? = null

        try {
            connection = DataSourceUtils.getConnection(dataSource)
            preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setString(1, name)
            resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                val resultMember = Member(
                    id = resultSet.getLong("id"),
                    name = resultSet.getString("name")
                )
                return resultMember
            } else {
                return null
            }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            resultSet?.close()
            preparedStatement?.close()
            DataSourceUtils.releaseConnection(connection,dataSource)

        }

    }

    override fun findAll(): List<Member> {
        val sql = "select * from member"
        var connection: Connection? = null
        var preparedStatement: PreparedStatement? = null
        var resultSet: ResultSet? = null
        val resultMemberList = mutableListOf<Member>()

        try {
            connection = DataSourceUtils.getConnection(dataSource)
            preparedStatement = connection.prepareStatement(sql)
            resultSet = preparedStatement.executeQuery()


            while (resultSet.next()) {
                val resultMember = Member(
                    id = resultSet.getLong("id"),
                    name = resultSet.getString("name")
                )
                resultMemberList.add(resultMember)
            }
            return resultMemberList

        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            resultSet?.close()
            preparedStatement?.close()
            DataSourceUtils.releaseConnection(connection,dataSource)

        }

    }
}