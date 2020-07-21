package com.winowsi.springaop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MyAOP
 * @description:
 * @author: 赵尧
 * @date: 2020-06-16 19:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String StudentNumber;
    private String user;
    private Integer password;
}
