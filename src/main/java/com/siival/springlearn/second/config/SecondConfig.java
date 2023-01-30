package com.siival.springlearn.second.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.siival.springlearn.config.transaction.TransactionConstant;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

/**
 * @time 2023年1月30日下午4:01:18
 * @author mark acrossxwall@gmail.com
 * @className SecondConfig
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {"com.siival.springlearn.second.repo"},
		entityManagerFactoryRef = "secondEntityManagerFactory",
		transactionManagerRef = TransactionConstant.SECOND_TRANSACTION_MANAGER
		)
public class SecondConfig {

	@Bean(name="secondDataSourceProperties")
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="secondDataSource")
    @ConfigurationProperties("app.datasource.second.configuration")
    public HikariDataSource secondDataSource(@Qualifier("secondDataSourceProperties") DataSourceProperties secondDataSourceProperties) {
        return secondDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("secondDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.siival.springlearn.second.data").persistenceUnit("second").build();
    }

    @Bean(name = TransactionConstant.SECOND_TRANSACTION_MANAGER)
    public PlatformTransactionManager secondTransactionManager(
        @Qualifier("secondEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory ) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
