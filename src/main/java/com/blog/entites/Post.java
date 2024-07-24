package com.blog.entites;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false , length = 10000)
    private String content;

    @Column(length = 200)
    private String image;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date updateDate;
    
    

    @ManyToOne
    private User users;


    @ManyToOne
    private Category categories;

}
