package multildatasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

	 public static void main(String[] args) {
		 
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		 HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
		 service.sayHello();
	}
}
