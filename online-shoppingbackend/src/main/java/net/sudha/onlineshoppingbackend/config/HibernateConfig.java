package net.sudha.onlineshoppingbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.sudha.onlineshoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "password@123";

	@Bean
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		// providing the database connection information

		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}

	@Bean

	public SessionFactory getSessionFactory(DataSource datasource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.sudha.onlineshoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		// TODO Auto-generated method stu
		
		Properties properties =new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
	
	@Bean
	
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}

}
