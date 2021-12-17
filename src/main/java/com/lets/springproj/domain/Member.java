package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Post> posts;

    @OneToMany(mappedBy = "member")
    private List<LikePost> likePosts;

    @OneToMany(mappedBy = "member")
    private List<ViewPost> viewPosts;

    @OneToMany(mappedBy = "member")
    private List<MemberTechStack> memberTechStacks;
}
