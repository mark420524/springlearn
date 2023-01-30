package com.siival.springlearn.config.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MultiTransactionAop {
 
	 
    private final  HandlerMultipleTransaction handlerMultipleTransaction;
 
    @Autowired
    public MultiTransactionAop(HandlerMultipleTransaction HandlerMultipleTransaction) {
        this.handlerMultipleTransaction = HandlerMultipleTransaction;
    }
 
    @Pointcut("@annotation(com.siival.springlearn.config.transaction.MultipleTransaction)")
    public void pointCut() {
    }
 
    @Around("pointCut() && @annotation(multipleTransaction)")
    public Object inMultiTransactions(ProceedingJoinPoint pjp, MultipleTransaction multipleTransaction) {
        return handlerMultipleTransaction.mergeMultipleTransaction(() -> {
            try {
                return pjp.proceed();
            } catch (Throwable throwable) {
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException) throwable;
                }
                throw new RuntimeException(throwable);
            }
        }, multipleTransaction.value());
    }
}