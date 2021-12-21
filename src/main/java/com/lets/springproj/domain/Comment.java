package com.lets.springproj.domain;

import javax.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Lob
    private String content;

    private Comment(Member member, Post post, String content){
        this.member = member;
        this.post = post;
        this.content = content;
    }

    public static Comment createComment(Member member, Post post, String content){
        Comment comment = new Comment(member, post, content);

        post.addComment(comment);

        return comment;


    }
    //==필드값 변경==//
    public Comment change(String content){
        this.content = content;

        return this;
    }

}
