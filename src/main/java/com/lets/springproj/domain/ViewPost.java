package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class ViewPost {
    @Id @GeneratedValue
    @Column(name = "VIEW_POST_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;
}
