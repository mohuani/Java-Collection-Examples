package com.mohuani.javacollectionexamples.entity;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: fdm
 * @date: 2022/8/21 15:16
 */
@Data
public class Teacher {

    private Integer id;

    private String name;

    private List<Integer> studentIdList;

}
