package com.wibaek.core.discount;

import com.wibaek.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
