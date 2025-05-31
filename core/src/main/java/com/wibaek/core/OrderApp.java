package com.wibaek.core;

import com.wibaek.core.member.Grade;
import com.wibaek.core.member.Member;
import com.wibaek.core.member.MemberService;
import com.wibaek.core.member.MemberServiceImpl;
import com.wibaek.core.order.Order;
import com.wibaek.core.order.OrderService;
import com.wibaek.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
