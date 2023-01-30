package com.siival.springlearn.first.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
 * @className FirstConfig
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {"com.siival.springlearn.first.repo"},
		entityManagerFactoryRef = "firstEntityManagerFactory",
		transactionManagerRef = TransactionConstant.FIRST_TRANSACTION_MANAGER
		)
public class FirstConfig {

	@Bean(name="firstDataSourceProperties")
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="firstDataSource")
    @Primary
    @ConfigurationProperties("app.datasource.first.configuration")
    public HikariDataSource firstDataSource(@Qualifier("firstDataSourceProperties") DataSourceProperties firstDataSourceProperties) {
        return firstDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    @Primary
    @Bean(name = "firstEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("firstDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.siival.springlearn.first.data").persistenceUnit("first").build();
    }

    @Primary
    @Bean(name = TransactionConstant.FIRST_TRANSACTION_MANAGER)
    public PlatformTransactionManager firstTransactionManager(
        @Qualifier("firstEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory ) {
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
