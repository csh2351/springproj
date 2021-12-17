package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class PostTechStack {
    @Id @GeneratedValue
    @Column(name = "POST_TECH_STACK_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
}
