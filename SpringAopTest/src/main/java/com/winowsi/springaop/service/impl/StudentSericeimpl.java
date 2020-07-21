package com.winowsi.springaop.service.impl;

import com.winowsi.springaop.entity.Student;
import com.winowsi.springaop.repository.StudentRepository;
import com.winowsi.springaop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 16:58
 **/
@Service
public class StudentSericeimpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository;
    @Override
    public List<Student> FindAll(Integer id) {
        return studentRepository.FindAll(id);
    }
}
