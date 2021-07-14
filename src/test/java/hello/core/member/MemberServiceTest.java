package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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
