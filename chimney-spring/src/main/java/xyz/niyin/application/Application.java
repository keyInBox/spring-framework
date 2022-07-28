package xyz.niyin.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.niyin.bean.HelloWorld;

final class Application {
	private Application(){}

	public static void main(String[] args) {
		//1. 创建 Spring 的 IOC 容器 AbstractApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 从 IOC 容器中获取 bean 的实例
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		// 根据类型来获取 bean 的实例: 要求在  IOC 容器中只有一个与之类型匹配的 bean, 若有多个则会抛出异常.
		// 一般情况下, 该方法可用, 因为一般情况下, 在一个 IOC 容器中一个类型对应的 bean 也只有一个.
		 HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		HelloWorld user = (HelloWorld) applicationContext.getBean("helloWorld");
		//3. 使用 bean
		helloWorld.hello();
	}
}
