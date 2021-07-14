package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "mamberA", Grade.VIP);
        memberService.join(memberA);
        Member memberB = memberService.findMember(memberA.getId());

        System.out.println("memberA = " + memberA.getName());
        System.out.println("memberB = " + memberB.getName());
    }
}
