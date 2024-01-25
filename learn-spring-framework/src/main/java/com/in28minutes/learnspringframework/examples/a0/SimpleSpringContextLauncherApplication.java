package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // 같은 package에서 scan한다면 package를 명시할 필요 없음
public class SimpleSpringContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context= new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
		
		
	}

}
