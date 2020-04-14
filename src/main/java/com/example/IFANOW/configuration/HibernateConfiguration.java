/*
package com.example.IFANOW.configuration;
 */

/*
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.example.IFANOW" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
    private Environment environment;

 
/*    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.example.IFANOW" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }*/
     
/*    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
       // System.out.println("======================environment.getRequiredPropert==================="+environment.getRequiredProperty("jdbc.url")+"/"+environment.getRequiredProperty("jdbc.username")+"/"+encryptDecrypt.decrypt(environment.getRequiredProperty("jdbc.password")));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.cache.use_second_level_cache", "true");
        properties.put("hibernate.cache.use_query_cache", "true");
        properties.put("hibernate.cache.generate_statistics", "true");
        properties.put("org.hibernate.cache.ehcache.configurationResourceName", "/ehcache.xml");
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        properties.put("hibernate.connection.provider_class",environment.getRequiredProperty("hibernate.connection.provider_class"));
        properties.put("hibernate.hikari.minimumIdle",environment.getRequiredProperty("hibernate.hikari.minimumIdle"));
        properties.put("hibernate.hikari.maximumPoolSize",environment.getRequiredProperty("hibernate.hikari.maximumPoolSize"));
        properties.put("hibernate.hikari.idleTimeout",environment.getRequiredProperty("hibernate.hikari.idleTimeout"));
        properties.put("hibernate.hikari.dataSource.url",environment.getRequiredProperty("jdbc.url"));
        properties.put("hibernate.hikari.dataSourceClassName", environment.getRequiredProperty("hibernate.hikari.dataSourceClassName"));
        properties.put("hibernate.hikari.dataSource.user", environment.getRequiredProperty("jdbc.username"));
        properties.put("hibernate.hikari.dataSource.password",environment.getRequiredProperty("jdbc.password"));
        return properties;        
    }
     
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
    
}
*/