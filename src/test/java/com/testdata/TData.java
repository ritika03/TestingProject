package com.testdata;

import org.testng.annotations.DataProvider;

import groovyjarjarasm.asm.commons.Method;


public class TData {

	@DataProvider (name = "data-provider")
	public Object[][] dpMethod (Method m){
		switch (m.getName()) {
		case "account": 
			return new Object[][] {{"valid","sr9631340@gmail.com", "999900001"},
			{"invalid", "standard_user","123"}};
		case "email": 
			return new Object[][] {{"Regarding testing"}, {"Hello, This is an automated script"}};
		}
		return null;
		
	}


	    }
	

