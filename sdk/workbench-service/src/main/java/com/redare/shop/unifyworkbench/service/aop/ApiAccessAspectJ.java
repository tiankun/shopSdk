package com.redare.shop.unifyworkbench.service.aop;

import com.redare.devframework.webplatform.sdk.core.arg.PermissionArg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/12 14:22
 * @version:
 */
@Aspect
@Component
public class ApiAccessAspectJ {

    @Pointcut("execution(* com.redare.devframework.webplatform.service.core.impl.PermissionSdkImpl.hasFunPermission(com.redare.devframework.webplatform.sdk.core.arg.PermissionArg.User))")
    public void point(){
    }

    @Before("point()")
    public void apiAccessLog(JoinPoint joinPoint){
        try {
            Object[] objArr = joinPoint.getArgs();
            if (objArr != null && objArr.length>0){
                ((PermissionArg.User) objArr[0]).setUserPlatform("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
