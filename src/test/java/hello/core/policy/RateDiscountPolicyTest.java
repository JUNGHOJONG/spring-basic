package hello.core.policy;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 고객은 10% 할인이 적용되어야 합니다")
    void VIP_고객이_맞습니다() {
        //GIVEN
        Member member = new Member(1L, "davinci", Grade.VIP);

        //THEN
        int discount = discountPolicy.disCount(member, 10000);

        //WHEN
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 고객이 아니면 할인이 적용되지 않습니다")
    void VIP_고객이_아닙니다() {
        //GIVEN
        Member member = new Member(2L, "hojong", Grade.BASIC);

        //WHEN
        int disCount = discountPolicy.disCount(member, 10000);

        //THEN
        assertThat(disCount).isEqualTo(0);
    }

}