package com.misterjerry.spring_study.controller

import com.misterjerry.spring_study.domain.Member
import com.misterjerry.spring_study.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController(
    @Autowired private val memberService: MemberService
) {

    @GetMapping("/members/new")
    fun createForm():String{
        return "members/createMemberForm.html"
    }

    @PostMapping("/members/new")
    fun create(memberForm: MemberForm): String{
        val member = Member(name = memberForm.name)
        memberService.join(member)
        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model):String{
        val members = memberService.findMembers()
        model.addAttribute("members",members)
        return "members/memberList"
    }

}