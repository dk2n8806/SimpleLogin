package com.admin.config;

import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(
		mode=AdviceMode.PROXY, proxyTargetClass=false
		, order=Ordered.LOWEST_PRECEDENCE
		)
public class PersistenceConfig {
	
	

    @Bean(name="dataSource")
    public DataSource dataSource() {
		String KEY_DRIVER_CLASS = "org.postgresql.Driver";
		String KEY_DB_URL = "jdbc:postgresql://localhost:5432/SimpleLogin";
		String KEY_DB_USERNAME = "username";
		String KEY_DB_PASSWORD = "password";
		
		BasicDataSource basic = new BasicDataSource();
		basic.setDriverClassName(KEY_DRIVER_CLASS);
		basic.setUrl(KEY_DB_URL);
		basic.setUsername(KEY_DB_USERNAME);
		basic.setPassword(KEY_DB_PASSWORD);
		
		return basic;
    }

    private Properties getProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    	properties.put("hibernate.show_sql", true);
      properties.put("hibernate.bytecode.use_reflection_optimizer", false);
      properties.put("hibernate.check_nullability", false);
      properties.put("hibernate.search.autoregister_listeners", false);
    	return properties;
    }
	
	
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
    {
        	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        	adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        	adapter.setGenerateDdl(true);
        	adapter.setShowSql(false);
   
        	
        	LocalContainerEntityManagerFactoryBean factory =
                													new LocalContainerEntityManagerFactoryBean();
        	
        	factory.setJpaVendorAdapter(adapter);
        	factory.setDataSource(this.dataSource());
        	factory.setPackagesToScan("com.common.entity");
        	factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        	factory.setValidationMode(ValidationMode.NONE);
        	//factory.setJpaPropertyMap(properties);
        	factory.setJpaProperties(getProperties());
        	return factory;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager()
    {
        return new JpaTransactionManager(
                this.entityManagerFactoryBean().getObject()
        );
    }
    
}
