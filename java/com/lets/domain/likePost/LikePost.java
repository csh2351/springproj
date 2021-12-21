package com.lets.domain.likePost;

import com.lets.domain.member.Member;
import com.lets.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
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
        status = LikePostStatus.INACTIVE;
        post.addView();
    }

    public static LikePost createLikePost(Member member, Post post){
        LikePost likePost = new LikePost(member, post);

        member.addLikePost(likePost);

        return likePost;
    }
    //==좋아요 메서드==//
    public void activateLike(){
        if(this.status == LikePostStatus.ACTIVE){
            throw new IllegalStateException("이미 좋아요 한 글은 좋아요가 불가능합니다.");
        }
        this.status = LikePostStatus.ACTIVE;
        post.addLike();
    }

    //==좋아요 취소 메서드==//
    public void deactivateLike(){
        if(this.status == LikePostStatus.INACTIVE) {
            throw new IllegalStateException("이미 좋아요 취소 한 글은 좋아요 취소가 불가능합니다.");
        }
        this.status = LikePostStatus.INACTIVE;
        post.minusLike();
    }
}
