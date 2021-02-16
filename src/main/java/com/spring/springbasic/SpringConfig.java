package com.spring.springbasic;

import com.spring.springbasic.repository.MemberRepository;
import com.spring.springbasic.repository.MemoryMemberRepository;
import com.spring.springbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드로 직접 스프링 빈 등록
// 직접 등록하거나 new 생성하면 AutoWired 적용 안됨
//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//}
