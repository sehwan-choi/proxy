 package hello.proxy.postprocecssor;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanPostProccessorTest {

    @Test
    void basicConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessConfig.class);

        B a = context.getBean("beanA", B.class);
        a.helloB();

        Assertions.assertThatThrownBy(() -> context.getBean(A.class)).isInstanceOf(NoSuchBeanDefinitionException.class);
    }


    @Configuration
    @Slf4j
    static class BeanPostProcessConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }

        @Bean
        public AtoBPostProcessor postProcessor() {
            return new AtoBPostProcessor();
        }
    }

    @Slf4j
    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }

    @Slf4j
    static class AtoBPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("beanName={} bean={}", beanName, bean);
            if (bean instanceof A) {
                return new B();
            }
            return bean;
        }
    }
}
