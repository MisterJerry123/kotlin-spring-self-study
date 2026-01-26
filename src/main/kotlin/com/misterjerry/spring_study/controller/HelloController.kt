package com.misterjerry.spring_study.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("hello")
    fun hello(model: Model): String{
        model.addAttribute("data", "Hello!!")
        return "hello"
    }

    @GetMapping("hello-mvc")
    fun helloMvc(@RequestParam("name") name:String, model: Model): String{
        model.addAttribute("name",name)
        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody
    fun helloString(@RequestParam("name") name:String): String{
        return "hello$name"
    }

    @GetMapping("hello-api")
    @ResponseBody
    fun helloApi(@RequestParam("name") name:String): Hello{
        val hello = Hello(name = name)
        return hello
    }

}
data class Hello (
    var name: String
)



