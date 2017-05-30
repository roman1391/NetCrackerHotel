package by.netcracker.hotel.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Common logger, marks beginning and ending for all involved controllers during
 * program execution
 * 
 * @author Roman Rodevich
 *
 */

@Aspect
@Component
public class ApplicationLogger {

    private static Logger log = Logger.getLogger(ApplicationLogger.class);

    @Around("execution(* by.netcracker.hotel.controllers..*.*(..))")
    public Object controllerLogging(ProceedingJoinPoint joinpoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("Controller begin: " + joinpoint.getSignature().toShortString());
        Object output = null;

        output = joinpoint.proceed();

        long time = System.currentTimeMillis() - start;
        log.info("Controller end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");
        return output;
    }

    @Around("execution(* by.netcracker.hotel.services..*.*(..))")
    public Object serviceLogging(ProceedingJoinPoint joinpoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("Service begin: " + joinpoint.getSignature().toShortString());
        Object output = null;

        output = joinpoint.proceed();

        long time = System.currentTimeMillis() - start;
        log.info("Service end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");
        return output;
    }

}
