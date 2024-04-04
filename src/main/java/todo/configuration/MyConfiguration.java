package todo.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration

//@ComponentScan({"controller","service","dao"}) we can also give the base package name,
@ComponentScan("todo")
public class MyConfiguration {
	
	@Bean
	public ViewResolver resolver()
	{
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		//will keep alll the web pages inside the folder so we use this. 
		resolver.setPrefix("frontend/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}
	@Bean
	public EntityManager getEM()
	{
		return Persistence.createEntityManagerFactory("abc").createEntityManager();
	}
}