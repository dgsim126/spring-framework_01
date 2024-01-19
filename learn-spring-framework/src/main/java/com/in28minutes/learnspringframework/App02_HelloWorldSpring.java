package com.in28minutes.learnspringframework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 *  Spring Context: Spring에서 Context는 애플리케이션의 객체들 간의 관계, 설정 및 라이프사이클을 관리하는데 사용되는 컨테이너입니다. 
 */
public class App02_HelloWorldSpring {

	public static void main(String[] args) {
		
		/**
		 * 1: Launch a Spring application or context
		 * @Configuration class로 Spring context를 시작해야 한다(AnnotationConfigApplicationContext 사용)
		 */
		var context= new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		/**
		 * 2: Configure the things that we want Spring to manage(Configuration 설정, 관리) 
		 * HelloWorldConfiguration - @Configuration
		 * name(method) - @Bean
		 */
		
		
		// 3: Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		
		System.out.println(context.getBean("address2"));
		System.out.println(context.getBean(Person.class)); 
		System.out.println(context.getBean(Address.class));
		System.out.println(context.getBean("person5Qulifier"));
		System.out.println("");
		
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
	}

}
