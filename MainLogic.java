package com.mondee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.around.AppConfiguration;
import com.around.*;

public class MainLogic {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiguration.class);
		com.around.HdfcBank hb = (com.around.HdfcBank) ac.getBean("pfb");
		hb.withdraw();
		hb.deposit();
	}

}