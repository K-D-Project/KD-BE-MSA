package com.example.space.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

import java.util.Date;

@MappedSuperclass
@Getter
public class BaseEntity {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updateTime;



}
