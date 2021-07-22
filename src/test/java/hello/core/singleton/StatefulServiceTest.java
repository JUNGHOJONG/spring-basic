package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulService() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigTest.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 사용자A
        statefulService1.order("ThreadA", 10000);

        // 사용자B
        statefulService1.order("ThreadB", 20000);

        // 사용자A의 금액은 10000이 나와야 한다
        System.out.println("statefulService1.price = " + statefulService1.getPrice());
        assertThat(statefulService1.getPrice()).isEqualTo(10000);
    }

    @Configuration
    public static class ConfigTest {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}