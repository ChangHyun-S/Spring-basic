package com.spring.springbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

//    http://localhost:8080/hello-mvc?name={~~~}
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); // key, name임
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // 응답받은 body에 직접 넣어주는거. 그대로 리턴됨
                    // 만약 ResponseBody가 없으면 view 찾으러감
//    @ResponseBody 를 사용
//    HTTP의 BODY에 문자 내용을 직접 반환
//    viewResolver 대신에 HttpMessageConverter 가 동작
//    기본 문자처리: StringHttpMessageConverter
//    기본 객체처리: MappingJackson2HttpMessageConverter
//    byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello" + {name}
    }

    @GetMapping("hello-api")
    @ResponseBody
    // JSON. key는 name, value는 파라미터 입력된것
    // {"name":"~~value~~"}
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String Name;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }
}
