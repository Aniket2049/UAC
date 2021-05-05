package as.uac.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "as.uac")
@PropertySource("classpath:hibernate-mysql.properties")
public class ApplicationConfig implements WebMvcConfigurer
{
	@Autowired
	private Environment environment;
	
	// ----- VIEW RESOLVER FOR SPRING WEB MVC ----- //
	@Bean
	public ViewResolver viewResolver ()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// ----- FOR CSS/JS/OTHER HTML STUFF ----- //
	@Override
	public void addResourceHandlers (final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	// ----- HIBERNATE SETTINGS ----- //
	
	@Bean
	public LocalSessionFactoryBean FactoryBean ()
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		factoryBean.setDataSource(DataSource());
		factoryBean.setPackagesToScan(environment.getProperty("hiberante.packagesToScan"));
		factoryBean.setHibernateProperties(GetHibernateProperties());
		
		return factoryBean;
	}
	
	@Bean
	public DataSource DataSource ()
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try
		{
			dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
			dataSource.setUser(environment.getProperty("jdbc.user"));
			dataSource.setPassword(environment.getProperty("jdbc.password"));
			
			dataSource.setInitialPoolSize(GetIntProperty("connection.pool.initialPoolSize"));
			dataSource.setMinPoolSize(GetIntProperty("connection.pool.minPoolSize"));
			dataSource.setMaxPoolSize(GetIntProperty("connection.pool.maxPoolSize"));
			dataSource.setMaxIdleTime(GetIntProperty("connection.pool.maxIdleTime"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	private Properties GetHibernateProperties ()
	{
		Properties props = new Properties();
		
		props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		
		return props;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager TransactionManager (SessionFactory sessionFactory)
	{
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
	// ----- UTILITY METHOD TO CONVERT STRING TO INT ----- //
	private int GetIntProperty (String propName)
	{
		String propVal    = environment.getProperty(propName);
		int    intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
}
