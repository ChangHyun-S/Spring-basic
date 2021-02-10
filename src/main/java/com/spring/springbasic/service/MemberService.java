package com.spring.springbasic.service;

import com.spring.springbasic.domain.Member;
import com.spring.springbasic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     **/
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 방지
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 이미 optional으로 들어가있어서 .ifPresent 쓰면 됨
        // ctrl + alt + m -> 소스 리팩토링
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**
     * 전체 화면 조회
     */
    public List<Member> findMembers() {
        // findAll() 리턴이 List<Member> 라서 바로 리턴
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
