package com.around;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = Account.class)
public class AppConfiguration {


	@Bean(value = "account")
	public Account myAccount() {
		return new Account();

	}

	@Bean(value = "authlog")
	public AuthLogAspect aspect() {
		return new AuthLogAspect();

	}

	@Bean(value="pfb")
	public ProxyFactoryBean factoryBean() {
		ProxyFactoryBean proxyInterfaces = new ProxyFactoryBean();

		proxyInterfaces.setInterfaces(HdfcBank.class);
		proxyInterfaces.setInterceptorNames("authlog");

		proxyInterfaces.setTarget(myAccount());
		return proxyInterfaces;	

	}

}
