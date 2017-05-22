package by.netcracker.hotel.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLogger {

    private static Logger log = Logger.getLogger(ApplicationLogger.class);

    public Object controllerLogging(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        log.info("method begin: " + joinpoint.getSignature().toShortString());
        Object output = null;
        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        log.info("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");
        return output;
    }

}
