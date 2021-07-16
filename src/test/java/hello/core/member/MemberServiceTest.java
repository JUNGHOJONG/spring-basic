package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //GIVEN
        Member davinci = new Member(1L, "davinci", Grade.VIP);

        //WHEN
        memberService.join(davinci);
        Member member = memberService.findMember(davinci.getId());

        //THEN
        Assertions.assertThat(davinci).isEqualTo(member);
    }
}
