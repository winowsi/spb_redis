package com.winowsi.springaop.service;

import com.winowsi.springaop.entity.Student;

import java.util.List;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 16:57
 **/
public interface StudentService {
    public List<Student> FindAll(Integer id);
}
