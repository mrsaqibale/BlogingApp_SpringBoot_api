package com.blog.entites;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String comment;

    @Column(nullable = false)
    private Date commentDate;

    @Column(nullable = false)
    private boolean isDeleted = false ;
    
    
    @ManyToOne
    private User users;

}
