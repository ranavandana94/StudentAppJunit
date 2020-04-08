package com.student.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class DatadrivenTest {
	
	
	public static Object[][] dataProviderAdd(){
		return new Object[][] {
			{1,1},
			{0,2},
			{3,4}
		};
	}
	
	@UseDataProvider("dataProviderAdd")
	@Test
	public void add2Numbers(int num1,int num2) {
		System.out.println(num1+num2);
	}

}
