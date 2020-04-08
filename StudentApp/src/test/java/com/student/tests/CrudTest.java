package com.student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.Regression;
import com.student.tags.Smoke;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.Tag;
@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {
	
	
	
	RequestFactory request=new RequestFactory();
	
	
	@Category(Smoke.class)
	@Story("This is a CRUD testing story")
	@Description("This is the test to get all student from database")
	@Feature("This a test to get all students from the database")
	@Test
	public void getAllStudents() {
	
	request.getAllStudents().then().spec(SpecificationFactory.getGenericResponseSpecification()).statusCode(200);
		
		
		
	}
	@Category(Regression.class)
	@Story("This is a CRUD testing story")
	@Description("This is the test to create new student ")
	@Feature("This a test to create and verify a new students ")
	@Tag("Regression,Smoke")
	@Test
	public void createNewStudent() {
		
		
		Faker fakeData=new Faker();
		
		String firstName=fakeData.name().firstName();
		String lastName=fakeData.name().lastName();
		String email=fakeData.internet().emailAddress();
		String programme="computer science";
		List<String> courses=new ArrayList<String>();
		courses.add("c++");
		courses.add("java");
		
		request.createNewStudent("", firstName, lastName, email, programme, courses)
		.then()
		.spec(SpecificationFactory.getGenericResponseSpecification())
		.statusCode(201);
		
		
	}

}
