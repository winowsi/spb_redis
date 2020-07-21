package com.winowsi.springaop.repository;

import com.winowsi.springaop.entity.Student;

import java.util.List;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 16:56
 **/
public interface StudentRepository {
    public List<Student> FindAll(Integer id);
}
