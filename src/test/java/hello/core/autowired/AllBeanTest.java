package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.policy.DiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);

        int fixDiscount = discountService.disCount(member, 10000, "fixDiscountPolicy");
        assertThat(fixDiscount).isEqualTo(1000);

        int rateDiscount = discountService.disCount(member, 30000, "rateDiscountPolicy");
        assertThat(rateDiscount).isEqualTo(3000);
    }

    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
        }

        public int disCount(Member member, int price, String discountCode) {
            DiscountPolicy discount = policyMap.get(discountCode);
            return discount.disCount(member, price);
        }
    }
}
