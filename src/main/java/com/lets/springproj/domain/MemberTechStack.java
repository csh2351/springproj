package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class MemberTechStack {
    @Id @GeneratedValue
    @Column(name = "MEMBER_TECH_STACK_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
}
