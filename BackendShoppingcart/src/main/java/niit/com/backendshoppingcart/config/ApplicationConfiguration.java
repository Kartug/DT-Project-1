package niit.com.backendshoppingcart.config;

import java.util.Locale.Category;
import java.util.Properties;
import java.util.function.Supplier;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import niit.com.backendshoppingcart.model.Catagory;
import niit.com.backendshoppingcart.model.Products;
import niit.com.backendshoppingcart.model.User;
import niit.com.backendshoppingcart.model.Suppliers;
@Configuration
@ComponentScan(basePackages="com.aj.james.backendproject")
@EnableTransactionManagement
public class ApplicationConfiguration {
		
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("get Datasourcemethod called");
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:h2:~/Backend");
		return dataSource;
	}
	private  Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Catagory.class);
		localSessionFactoryBuilder.addAnnotatedClass(Products.class);
		localSessionFactoryBuilder.addAnnotatedClass(Suppliers.class);
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Autowired
	    @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	
	   System.out.println("Hitting th eDB");
	   DriverManagerDataSource  dataSource=new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3307/ndb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("password@123");
	   
	    return dataSource;
	    }
	    
	    
	    private Properties getHibernateProperties() {
	    	System.out.println("Hitting the Hibernate");
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    properties.put("hbm2ddl.auto", "create");	
	    System.out.println("check:"+properties.get("hbm2ddl.auto"));
	    return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	System.out.println("Hitting th session");
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	    sessionBuilder.addAnnotatedClasses(Category.class);
	    sessionBuilder.addAnnotatedClasses(Suppliers.class);
	    sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClasses(Product.class);
	    
	   
	    sessionBuilder.addAnnotatedClass(Category.class);
	    return sessionBuilder.buildSessionFactory();
	    }
	    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	SessionFactory sessionFactory) {
		System.out.println("Hitting th transaction");
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	sessionFactory);

	return transactionManager;
	
*/	}
	