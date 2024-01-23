package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		// Logic
		System.out.println("Some Initialization Logic");
		this.classA= classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan // 같은 package에서 scan한다면 package를 명시할 필요 없음
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context= new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);){
			// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println("Initialization of context is completed");
			context.getBean(ClassB.class).doSomething();
		}
		
	}

}
