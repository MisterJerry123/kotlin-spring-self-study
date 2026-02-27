package com.misterjerry.spring_study.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Component
@Aspect
class TimeTraceAop {
    @Around("execution(* com.misterjerry.spring_study.service..*(..))")
    fun execute(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()
        try {
            return joinPoint.proceed()
        } finally {
            val finish = System.currentTimeMillis()
            val result = finish - start
            println(joinPoint.toString() + " " + result.toString() + "ms")

        }

    }


}