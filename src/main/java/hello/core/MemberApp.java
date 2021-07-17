package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "mamberA", Grade.VIP);
        memberService.join(memberA);
        Member memberB = memberService.findMember(memberA.getId());

        System.out.println("memberA = " + memberA.getName());
        System.out.println("memberB = " + memberB.getName());
    }
}
