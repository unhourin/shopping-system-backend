package com.yun.study.springbootstudy.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "b_thing")
public class Thing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String cover;

    private String description;

    private String price;

    private String status;

    private String createTime;

    private String repertory;

    private String score;

    private String pv;

    private String recommendCount;

    private String wishCount;

    private String collectCount;

    private Long classificationId;
}
