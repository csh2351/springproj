package com.lets.domain.tag;

import com.lets.domain.postTechStack.PostTechStack;
import lombok.Builder;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
public class Tag {
    @Id @GeneratedValue
    @Column(name = "TAG_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<PostTechStack> posts = new ArrayList<>();

    private Tag(String name){
        this.name = name;
    }

    public static Tag createTag(String name){
        Tag tag = new Tag(name);
        return tag;
    }

    //==연관관계 메서드==//
    public void addPostTechStack(PostTechStack postTechStack){
        this.posts.add(postTechStack);
    }
}
