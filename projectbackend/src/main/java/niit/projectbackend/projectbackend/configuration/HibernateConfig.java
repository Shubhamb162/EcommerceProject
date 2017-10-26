package niit.projectbackend.projectbackend.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//configuration class
@Configuration
@EnableTransactionManagement	//Enabling transaction
@ComponentScan("niit.projectbackend.projectbackend")	//for scanning the whole project
public class HibernateConfig {
	//Bean 
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/spring");
		dataSource.setUsername("shubham");
		dataSource.setPassword("");
		return dataSource;		
	}
	
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource());
		//sessionFactory.getDataSource();
		//LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		//sessionFactory(dataSource);
		localSessionFactoryBuilder.scanPackages("niit.projectbackend.projectbackend");
		localSessionFactoryBuilder.addProperties(hibernateProperties());
		return localSessionFactoryBuilder.buildSessionFactory();
		//return localSessionFactoryBuilder;
	}
	
	public Properties hibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate_format_sql","true");
		properties.put("hibernate.show_sql","true");
		//properties.put("hibernate.show_sql","org.hibernate.SQL");
		properties.put("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		//hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;	
	}
}
