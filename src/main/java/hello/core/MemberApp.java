package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member memberA = new Member(1L, "mamberA", Grade.VIP);
        memberService.join(memberA);
        Member memberB = memberService.findMember(memberA.getId());

        System.out.println("memberA = " + memberA.getName());
        System.out.println("memberB = " + memberB.getName());
    }
}
