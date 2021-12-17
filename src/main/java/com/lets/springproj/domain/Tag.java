package com.lets.springproj.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Entity
public class Tag {
    @Id @GeneratedValue
    @Column(name = "TAG_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    private List<Post> posts;
}
