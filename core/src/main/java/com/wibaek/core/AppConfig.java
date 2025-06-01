package com.wibaek.core;

import com.wibaek.core.discount.DiscountPolicy;
import com.wibaek.core.discount.RateDiscountPolicy;
import com.wibaek.core.member.MemberRepository;
import com.wibaek.core.member.MemberService;
import com.wibaek.core.member.MemberServiceImpl;
import com.wibaek.core.member.MemoryMemberRepository;
import com.wibaek.core.order.OrderService;
import com.wibaek.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
