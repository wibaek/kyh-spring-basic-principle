package com.wibaek.core;

import com.wibaek.core.discount.RateDiscountPolicy;
import com.wibaek.core.member.MemberService;
import com.wibaek.core.member.MemberServiceImpl;
import com.wibaek.core.member.MemoryMemberRepository;
import com.wibaek.core.order.OrderService;
import com.wibaek.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
