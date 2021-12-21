package com.lets.springproj.domain;

import javax.persistence.*;

@Entity
public class LikePost {
    @Id
    @GeneratedValue
    @Column(name = "LIKE_POST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Enumerated(EnumType.STRING)
    private LikePostStatus status;

    private LikePost(Member member, Post post){
        this.member = member;
        this.post = post;
    }

    public static LikePost createLikePost(Member member, Post post){
        LikePost likePost = new LikePost(member, post);

        member.addLikePost(likePost);

        return likePost;
    }
    //==좋아요 메서드==//
    public void activateLike(){
        this.status = LikePostStatus.ACTIVE;
        post.addLike();
    }

    //==좋아요 취소 메서드==//
    public void deactivateLike(){
        this.status = LikePostStatus.INACTIVE;
        post.minusLike();
    }
}
