package com.lets.springproj.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<LikePost> likePosts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberTechStack> memberTechStacks = new ArrayList<>();

    private Member(String name){
        this.name = name;
    }

    //==연관관계 메서드==//
    public void addPost(Post post){
        posts.add(post);

    }

    //==연관관계 메서드==//
    public void addLikePost(LikePost likePost){
        likePosts.add(likePost);
    }

    //==연관관계 메서드==//
    public void addMemberTechStack(MemberTechStack memberTechStack){

        this.memberTechStacks.add(memberTechStack);
        memberTechStack.setMember(this);
    }

    //==생성 메서드==//
    public static Member createMember(String name, List<MemberTechStack> memberTechStacks){
        Member member = new Member(name);

        for(MemberTechStack memberTechStack : memberTechStacks){
            member.addMemberTechStack(memberTechStack);
        }
        return member;
    }



    //==필드값 변경==//
    public void change(String name, List<MemberTechStack> memberTechStacks){
        this.name = name;

        //memberTechStacks에서 memberId로 먼저 삭제 후
        for(MemberTechStack memberTechStack : memberTechStacks){
            this.addMemberTechStack(memberTechStack);
        }
    }

}
