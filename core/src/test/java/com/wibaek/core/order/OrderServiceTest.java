package com.wibaek.core.order;

import com.wibaek.core.AppConfig;
import com.wibaek.core.member.Grade;
import com.wibaek.core.member.Member;
import com.wibaek.core.member.MemberService;
import com.wibaek.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        // Given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // When
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // Then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
