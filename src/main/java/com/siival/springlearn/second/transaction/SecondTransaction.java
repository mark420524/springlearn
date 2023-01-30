package com.siival.springlearn.second.transaction;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.siival.springlearn.config.transaction.TransactionConstant;

/**
 * @time 2023年1月30日下午5:10:43
 * @author mark acrossxwall@gmail.com
 * @className SecondTransaction
 */
@Component
public class SecondTransaction {

	@Transactional(transactionManager = TransactionConstant.SECOND_TRANSACTION_MANAGER)
    public <V> V inTransaction(Callable<V> callable) {
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
