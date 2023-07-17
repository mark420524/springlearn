package com.siival.springlearn.config.transaction;

import org.hibernate.BaseSessionEventListener;

import com.siival.springlearn.first.config.TransactionInfo;

/**
 * @time 2023年7月13日15:19:10
 * @author mark acrossxwall@gmail.com
 * @className TransactionInfoSessionEventListener
 */
public class TransactionInfoSessionEventListener extends BaseSessionEventListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6752582957976602680L;
	private final TransactionInfo transactionInfo;
	 
    /**
     * Executes when a JPA EntityManager is created.
     */
    public TransactionInfoSessionEventListener() {
        transactionInfo = new TransactionInfo();
    }
 
    /**
     * Executes after a JDBC statement was executed.
     */
    @Override
    public void jdbcExecuteStatementEnd() {
        
    }
 
    /**
     * Executes after the commit or rollback was called
     * on the JPA EntityTransaction.
     */
    @Override
    public void transactionCompletion(boolean successful) {
        
    }
 
    /**
     * Executes after JPA EntityManager is closed.
     */
    @Override
    public void end() {
        transactionInfo.close();
    }
 
    
    
}
