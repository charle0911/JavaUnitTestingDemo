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
    private String type;

    @Column
    private String topic;

    @Column
    private Date createDate = new Date();

    @Column
    private Date updateDate;

    @Column
    private long click;

    public Topic setId(long id) {
        this.id = id;
        return this;
    }

    public Topic setType(String type) {
        this.type = type;
        return this;
    }

    public Topic setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public Topic setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public Topic setClick(long click) {
        this.click = click;
        return this;
    }
}
