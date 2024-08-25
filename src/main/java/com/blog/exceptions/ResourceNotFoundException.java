package com.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    String resource ;
    String field ;
    Long id ;

    public ResourceNotFoundException(String resource, String field, Long id){
        super(String.format ("%s not found with %s : %s" , resource, field, id));
        this.resource = resource ;
        this.field = field;
        this.id = id ;
    }

    public ResourceNotFoundException(String resource , String field){
        super(String.format("%s not found with username: %s",resource, field));
        this.resource = resource;
        this.field = field;

    }
}
