package com.siival.springlearn.config.transaction;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @time 2023年1月30日下午5:02:47
 * @author mark acrossxwall@gmail.com
 * @className MultipleTransaction
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultipleTransaction {
	String[] value() default {};
}
