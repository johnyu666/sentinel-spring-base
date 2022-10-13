package cn.johnyu.sentinel;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SenApp  {
    public static void main(String[] args) {
        SpringApplication.run(SenApp.class,args);
    }
//    此对象会对容器中所有的@SentinelResource 进行代理
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }



}
