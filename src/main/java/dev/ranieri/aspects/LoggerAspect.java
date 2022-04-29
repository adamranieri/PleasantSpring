package dev.ranieri.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect// marks that component as a Aspect holding advice methods
public class LoggerAspect {

    static int requestCounter = 0;

    //Advice method
    @Before("logJP()")// connect my advice to the point cut express
    public static void logCounter(){
        requestCounter++;
        System.out.println("The total amount of requests is : " + requestCounter);
    }

    @After("logJP()")// execute the advice method after the joinppint method has finished executing
    public static void finished(){
        System.out.println("Request has finished processing");
    }

    // Pointcut expression that targets the joinpoints (Places that can be adviced)
    //When anything within the controllers package is called
    @Pointcut("within(dev.ranieri.controllers..*)")
    private void logJP(){};// empty method with no usefulness

}
