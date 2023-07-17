package com.siival.springlearn.first.config;

import org.slf4j.MDC;

import com.siival.springlearn.util.UUIDUtil;

/**
 * @time 2023年7月13日15:21:02
 * @author mark acrossxwall@gmail.com
 * @className TransactionInfo
 */
public class TransactionInfo {

	private final String persistenceContextId;
	 
    private String transactionId;
 
    private MDC.MDCCloseable mdc;
 
    public TransactionInfo() {
        this.persistenceContextId = UUIDUtil.getRandomUUID();
        setMdc();
    }
 
    public boolean hasTransactionId() {
        return transactionId != null;
    }
 
    public TransactionInfo setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        setMdc();
        return this;
    }
 
    private void setMdc() {
        this.mdc = MDC.putCloseable(
            "txId", persistenceContextId  
        );
    }
 
    public void close() {
        if(mdc != null) {
            mdc.close();
        }
    }
}
