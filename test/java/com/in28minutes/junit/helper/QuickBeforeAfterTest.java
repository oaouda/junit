package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}
	// execute the setup for each test
	@Before
	public void setup() {
		System.out.println("Before Test");
				
	}
	// after every test methods
	@After
	public void teardown() {
		System.out.println("After");
		
	}
	
	@Test
	public void test1() {
		System.out.println("test1 executed");						
	}
	
	@Test
	public void test2() {
		System.out.println("test2 executed");
	}

}
