package hello.core.policy;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private static final int rateDiscountAmount = 10;

    @Override
    public int disCount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return itemPrice * rateDiscountAmount / 100;
        } else {
            return 0;
        }
    }
}
