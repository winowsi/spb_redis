package com.go;

import com.winowsi.springaop.Nonprogramming.TargetEN;
import com.winowsi.springaop.Programming.EnhanceE;
import com.winowsi.springaop.Programming.TargetE;
import com.winowsi.springaop.entity.Student;
import com.winowsi.springaop.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 16:36
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {
    private static TargetE targetE=new TargetE();
    private static EnhanceE enhanceE=new EnhanceE();
    @Autowired
    private   StudentService studentService;
    @Autowired
    private TargetEN targetEN;
    //注解式增强记得添加驱动注解
    @Test
    public  void bb(){
        targetEN.printing();
    }
    //编程式增强
    @Test
    public  void aa(){
        Enhancer e =new Enhancer();
        e.setSuperclass(TargetE.class);
        e.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                enhanceE.Before();
                Object invoke = method.invoke(targetE, objects);
                enhanceE.After();
                return invoke;
            }
        });
        //cjlib增强完创建调用
        TargetE targetE = (TargetE) e.create();
        targetE.printing();
    }
    @Test
    public void cc(){
        List<Student> students = studentService.FindAll(1);
        System.out.println(students.toString());

    }
}
