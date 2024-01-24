package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready");
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("PostConstruct");
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("PreDestory");
		System.out.println("Clean Up");
	}
	
}

@Component
class SomeDependency{
	
	public SomeDependency() {
		System.out.println("Fux");
	}

	public void getReady() {
		System.out.println("Some logic using SomeDependcy");
		
	}
	
}

@Configuration
@ComponentScan // 같은 package에서 scan한다면 package를 명시할 필요 없음
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context= new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class);){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
		
		
	}

}
