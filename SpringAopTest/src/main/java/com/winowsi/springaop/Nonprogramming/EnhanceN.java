package com.winowsi.springaop.Nonprogramming;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 15:18
 **/
@Component
@Aspect
public class EnhanceN {
    @Before("execution(* com.winowsi.springaop.Nonprogramming..*(..))")
    public void befor(){
        System.out.println("增强前");
    }
    @AfterReturning("execution(* com.winowsi.springaop.Nonprogramming..*(..))")
    public void after(){
        System.out.println("增强后");
    }
    @Around("execution(* com.winowsi.springaop.Nonprogramming..*(..))")
    public Object ther(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("增强前(循环)");
        Object proceed = joinPoint.proceed();
        System.out.println("增强后（循环）");
        return proceed;
    }
    @AfterThrowing("execution(* com.winowsi.springaop.Nonprogramming..*(..))")
    public  void  afterthrowing(){
        System.out.println("异常抛出增强");
    }
    @After("execution(* com.winowsi.springaop.Nonprogramming..*(..))")
    public void verafter(){
        System.out.println("最终增强");
    }
}
