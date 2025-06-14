package com.blog_api_com.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title", nullable = false, length = 100)
    private String title;

    @Column(length = 10000)
    private String content;

    private String imageName;
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    private User user;

    private Set<Comment> comments = new HashSet<Comment>();
}
