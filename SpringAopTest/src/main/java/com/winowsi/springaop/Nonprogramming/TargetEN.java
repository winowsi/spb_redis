package com.winowsi.springaop.Nonprogramming;

import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

/**
 * @program: springaop
 * @description:
 * @author: 赵尧
 * @date: 2020-07-09 15:17
 **/
@Component
public class TargetEN {
    public void printing(){
        System.out.println("No_programming>>>enhance...");
    }
}
