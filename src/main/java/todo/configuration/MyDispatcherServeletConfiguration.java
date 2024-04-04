package todo.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServeletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//it willl pass the configuration class to the container.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class [] {MyConfiguration.class};
	}

	//maps all the url and send that to the dispatcher servlet.
	@Override
	protected String[] getServletMappings() {
	String [] a= {"/"};//rather than giving the particular url name we give / so it will consider all the url requests
		return a;
	}

}
