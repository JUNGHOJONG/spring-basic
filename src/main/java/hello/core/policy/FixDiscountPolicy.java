package hello.core.policy;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private static final int fixedDiscountAmount = 1000;

    @Override
    public int disCount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return fixedDiscountAmount;
        } else {
            return 0;
        }
    }
}
