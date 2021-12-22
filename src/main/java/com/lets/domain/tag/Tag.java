package com.lets.domain.tag;

import com.lets.domain.BaseTimeEntity;
import com.lets.domain.postTechStack.PostTechStack;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Tag extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "TAG_ID")
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<PostTechStack> postTechStacks = new ArrayList<>();

    private Tag(String name){
        this.name = name;
    }

    public static Tag createTag(String name){
        Tag tag = new Tag(name);
        return tag;
    }

    //==연관관계 메서드==//
    public void addPostTechStack(PostTechStack postTechStack){
        this.postTechStacks.add(postTechStack);
    }
}
