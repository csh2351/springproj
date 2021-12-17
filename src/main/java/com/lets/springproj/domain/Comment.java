package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Column
    private String content;
}
