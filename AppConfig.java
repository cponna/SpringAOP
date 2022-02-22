package com.mondee;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = Account.class)
public class AppConfig {


	@Bean(value = "account")
	public Account myAccount() {
		return new Account();

	}

	@Bean(value = "auth")
	public AuthenticationAspect aspect() {
		return new AuthenticationAspect();

	}
	@Bean(value="log")
	public LoggingAspect loginAspect() {
		return new LoggingAspect();

	}

	@Bean(value="pfb")
	public ProxyFactoryBean factoryBean() {
		ProxyFactoryBean proxyInterfaces = new ProxyFactoryBean();

		proxyInterfaces.setInterfaces(HdfcBank.class);
		proxyInterfaces.setInterceptorNames("auth");
		proxyInterfaces.setInterceptorNames("log");

		proxyInterfaces.setTarget(myAccount());
		return proxyInterfaces;	

	}

}