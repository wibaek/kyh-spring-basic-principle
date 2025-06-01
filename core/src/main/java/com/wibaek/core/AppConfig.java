package com.wibaek.core;

import com.wibaek.core.discount.DiscountPolicy;
import com.wibaek.core.discount.RateDiscountPolicy;
import com.wibaek.core.member.MemberRepository;
import com.wibaek.core.member.MemberService;
import com.wibaek.core.member.MemberServiceImpl;
import com.wibaek.core.member.MemoryMemberRepository;
import com.wibaek.core.order.OrderService;
import com.wibaek.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
