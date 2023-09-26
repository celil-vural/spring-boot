package com.springbootaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    /*
    * @AfterReturning
    * @AfterThrowing
    * @After
    * @Around
    * @Before
    * */
    @Before("execution(* com.springbootaop.service.*.getMessage(..))") // * olan yere class ismi gelebilir
    public void beforeGetMessage(JoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
        System.out.println("Before the fonk param:"+args[0]);
        System.out.println(joinPoint.getSignature());
    }
    @After("execution(* com.springbootaop.service.*.getMessage(..))")
    public void afterGetMessage(JoinPoint joinPoint){
        System.out.println("After the fonk para:"+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
