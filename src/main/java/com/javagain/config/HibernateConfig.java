package com.javagain.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class define all the Hibernate configs
 * 
 * @author Sandeep.Sharma
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
public class HibernateConfig {
	
	/**
	 * Inject Environment to access value from properties files 
	 */
	@Autowired
	private Environment env;
	
	/**
	 * Build SectionFactory bean
	 * 
	 * @return
	 */
	@Bean
    public SessionFactory sessionFactory() {
            LocalSessionFactoryBuilder builder =
            		new LocalSessionFactoryBuilder(dataSource());            
            builder.scanPackages("com.javagain.entity")
                  .addProperties(hibernateProperties());

            return builder.buildSessionFactory();
    }
	
	/**
	 * Build Datasrouce bean
	 * @return
	 */
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		
		return dataSource;
	}
	
	/**
	 * Set hibernate properties
	 * 
	 * @return
	 */
	public Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.format_sql", "true");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		
		return prop;
	}
	
	/**
	 * Create Transaction manager bean
	 * 
	 * @return
	 */
	@Bean
    public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
    }
}
