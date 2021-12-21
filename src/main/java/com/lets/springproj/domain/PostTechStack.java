package com.lets.springproj.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PostTechStack {
    @Id @GeneratedValue
    @Column(name = "POST_TECH_STACK_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    private PostTechStack(Tag tag){
        this.tag = tag;
    }

    public static PostTechStack createPostTechStack(Tag tag){
        PostTechStack postTechStack = new PostTechStack(tag);
        tag.addPostTechStack(postTechStack);

        return postTechStack;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
