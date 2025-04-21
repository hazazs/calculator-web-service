package hu.hazazs.calculator.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	private static final String NAMESPACE_URI = "http://hazazs.hu/calculator-web-service";
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(final ApplicationContext applicationContext) {
		final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean<>(servlet, "/calculator/*");
	}

	@Bean(name = "calculator")
	public DefaultWsdl11Definition defaultWsdl11Definition(final XsdSchema calculatorSchema) {
		final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		
		wsdl11Definition.setPortTypeName("CalculatorPort");
		wsdl11Definition.setLocationUri("/calculator");
		wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
		wsdl11Definition.setSchema(calculatorSchema);
		
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema calculatorSchema() {
		return new SimpleXsdSchema(new ClassPathResource("calculator.xsd"));
	}
	
}