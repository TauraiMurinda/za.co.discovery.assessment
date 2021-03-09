package za.co.discovery.application.aspects.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
public class AtmControllerAspect {
	
	    private ReentrantReadWriteLock rwLock;
	    private Lock acquireReadLock;
	    private Lock acquireWriteLock;
	    
	    private Logger logger = LoggerFactory.getLogger(this.getClass());
        
	    
	
	  //@Pointcut("execution(* com.in28minutes.spring.aop.springaop.data.
	  // @Pointcut("within(za.co.discovery.application.controller.AtmController.*())")
	  
	  @Pointcut("execution(public Integer za.co.discovery.application.controller.AtmController.withDraw())"
	  ) public void controllerExecution() { }
	  
	  @Around("controllerExecution()") public Object around(ProceedingJoinPoint joinPoint) throws Throwable 
	  { 
		  //acquireReadLock.tryLock();

		  String name =  joinPoint.getSignature().getName(); 
	      Object output = joinPoint.proceed();
	      //acquireReadLock.unlock(); 
	      logger.info(name +"   executed");
	  
	  return output;
	  
	  }
	 

}
