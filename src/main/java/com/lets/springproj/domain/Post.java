package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Post {
    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    private long likeCount;

    private long viewCount;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<PostTechStack> postTechStacks;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    private PostState postState;
}
