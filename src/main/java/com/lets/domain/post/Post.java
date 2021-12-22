package com.lets.domain.post;

import com.lets.domain.BaseTimeEntity;
import com.lets.domain.comment.Comment;
import com.lets.domain.member.Member;
import com.lets.domain.postTechStack.PostTechStack;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    private Long likeCount;

    private Long viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostTechStack> postTechStacks = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @NotNull
    @NotEmpty
    private String title;

    @Lob
    @NotNull
    @NotEmpty
    private String content;

    private Post(Member member, String title, String content){
        this.member = member;
        this.title = title;
        this.content = content;
        this.likeCount = 0L;
        this.viewCount = 0L;
        status = PostStatus.RECRUITING;
    }


    //==연관관계 메서드==//
    public void addComment(Comment comment){
        comments.add(comment);
    }

    //==연관관계 메서드==//
    public void addPostTechStack(PostTechStack postTechStack){
        this.postTechStacks.add(postTechStack);
        postTechStack.setPost(this);

    }

    //==생성 메서드==//
    public static Post createPost(Member member, String title, String content, List<PostTechStack> postTechStacks){
        Post post = new Post(member, title, content);

        for(PostTechStack postTechStack : postTechStacks){
            post.addPostTechStack(postTechStack);
        }
        member.addPost(post);

        return post;
    }

    //==좋아요 클릭==//
    public void addLike(){
        this.likeCount++;
    }

    //==좋아요 취소==//
    public void minusLike(){
        this.likeCount--;
    }

    //==조회수 증가==//
    public void addView(){
        this.viewCount++;
    }

    //==필드 변경==//
    public Post change(String content, PostStatus postStatus){
        this.content = content;
        this.status = status;

        return this;
    }


}
