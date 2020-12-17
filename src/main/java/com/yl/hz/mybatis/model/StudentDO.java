package com.yl.hz.mybatis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDO implements Serializable {

    private String name;

    private Integer age;

    private Integer sex;

}
