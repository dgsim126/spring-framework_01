package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 이 클래스는 Spring Bean을 정의하는 Java 기반 설정 클래스입니다.
 * @Configuration 어노테이션은 해당 클래스가 Spring Bean 구성 클래스임을 나타냅니다.
 * @Bean 어노테이션을 사용하여 Spring이 관리하는 Bean을 정의하는 메서드를 제공합니다. 
 * 이 메서드는 "name"이라는 이름의 문자열을 반환하도록 되어 있습니다.
 */

// record를 이용하면 getter, setter, 생성자를 생성할 필요가 없다.
record Person(String name, int age, Address address) {};
record Address(String firstLine, String ciry) {};

@Configuration
public class HelloWorldConfiguration {
	
	/**
	 * Spring에서 관리하는 것들을 Spring Bean이라고 한다.
	 * Configuration(설정) class에서 method를 정의하여 Spring Bean을 생성할 수 있다.
	 */ 
	@Bean 
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean 
	public Person person() {
		return new Person("Ravi", 20, new Address("Baker Street", "London"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address2) { // name, age, address2
		return new Person(name, age, address2); 
	}
	
	@Bean
	@Primary
	// No qualifiying bean of type 'com.in28minutes.learnspringframework.Address'
	// available: expected single matching bean but found 2: address2, address3
	public Person person4Parameters(String name, int age, Address address) { 
		return new Person(name, age, address); 
	}
	
	@Bean
	public Person person5Qulifier(String name, int age, @Qualifier("address3qualifier") Address address) { 
		return new Person(name, age, address); 
	}
	
	@Bean(name= "address2")
	@Primary
	public Address address() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name="address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Motinagar", "Hyderabad");
	}
}
