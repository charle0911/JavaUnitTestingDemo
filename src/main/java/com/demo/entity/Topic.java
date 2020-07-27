package com.demo.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String topic;

    @Column
    private Date createDate;

    @Column
    private Date updateDate;

    @Column
    private long click;
}
