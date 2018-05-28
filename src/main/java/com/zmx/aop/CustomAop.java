package com.zmx.aopConfig;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CustomAop {
    @Pointcut("execution(* com.zmx.DemoApplication.home(..))")
    public   void performance(){}
    @Before("performance()")
    public  void  before(){
        System.out.print("before");
    }
    @Around("performance()")
    public  Object   around(ProceedingJoinPoint jp)  throws Throwable {
        System.out.print("getArgs" + "||" + jp.getArgs());
        Object[] args = jp.getArgs();
        System.out.print("count"+args.length);
        for (Object ob:args)
        {
            System.out.print(ob);
        }
        return jp.proceed();
    }
}
