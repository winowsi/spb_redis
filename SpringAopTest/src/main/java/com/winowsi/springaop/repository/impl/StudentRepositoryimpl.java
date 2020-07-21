package com.winowsi.springaop.repository.impl;

import com.winowsi.springaop.entity.Student;
import com.winowsi.springaop.repository.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 16:57
 **/
@Repository
public class StudentRepositoryimpl implements StudentRepository {
    @Override
    public List<Student> FindAll(Integer id) {
        ApplicationContext app= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JdbcTemplate bean = app.getBean(JdbcTemplate.class);
        List<Student> query = bean.query("select * from Student.student where id=?", new BeanPropertyRowMapper<>(Student.class), id);
        return query;
    }

}
