package dev.ranieri.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Aspect
public class SecurityAspect {

    // Surrounds the joinpoint
    // Allows you to execute it before and after it executes
    @Around("securityJP()") // pjp is the an object that is the method call itself
    public Object authenticate(ProceedingJoinPoint pjp) throws Throwable {
        // grabbing the http request and response objects from each  http request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        String auth = request.getHeader("Authorization");
        if( auth == null || !auth.equals("pa$$word")){
            response.sendError(401,"You are not authorized");//
            return null;
        }else{
            Object obj = pjp.proceed();// letting the method call continue to execut. OBJ is the return of that method call
            return obj;
        }

    }

    @Pointcut("@annotation(dev.ranieri.aspects.Secured)")
    private void securityJP(){}
}
