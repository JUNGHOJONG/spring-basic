package hello.core.policy;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private static final int RateDiscountAmount = 10;

    @Override
    public int disCount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return itemPrice * RateDiscountAmount / 100;
        } else {
            return 0;
        }
    }
}
