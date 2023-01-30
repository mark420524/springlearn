package com.siival.springlearn.config.transaction;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siival.springlearn.first.transaction.FirstTransaction;
import com.siival.springlearn.second.transaction.SecondTransaction;

@Component
public class HandlerMultipleTransaction {
 
    @Autowired
    private FirstTransaction firstTransaction;
 
    @Autowired
    private SecondTransaction secondTransaction;
 
    public <V> V mergeMultipleTransaction(Callable<V> callable, String[] transactions) {
        if (callable == null) {
            return null;
        }
 
        Callable<V> combined = Stream.of(transactions)
                .distinct()
                .reduce(callable, (r, tx) -> {
                    switch (tx) {
                        case  TransactionConstant.FIRST_TRANSACTION_MANAGER:
                            return () -> firstTransaction.inTransaction(r);
                        case TransactionConstant.SECOND_TRANSACTION_MANAGER:
                            return () -> secondTransaction.inTransaction(r);
                        default:
                            return null;
                    }
                }, (r1, r2) -> r2);
 
        try {
            return combined.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}