package com.mondee;

import org.springframework.stereotype.Component;

@Component
public class Account implements HdfcBank{

	public void withdraw() {

		System.out.println("With draw account");
	}

	public void deposit() {

		System.out.println("Deposit Amount");
	}


}