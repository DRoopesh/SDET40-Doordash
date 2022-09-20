package org.sdet40.practise;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractise2Test {
@BeforeSuite
public void suiteSetup1() {
	System.out.println("Before suite");
}

@BeforeTest
public void testSetup1() {
	System.out.println("Before test");
}

@BeforeClass
public void classSetup1() {
	System.out.println("Before class");

}

@AfterClass
public void classSetup2() {
	System.out.println("After class");
}

@BeforeMethod
public void methodSetup1() {
	System.out.println("Before method");
}

@AfterSuite
public void suiteSetup2() {
	System.out.println("After suite");
}

@AfterTest
public void testSetup2() {
	System.out.println("After test");
}

@AfterMethod
public void methodSetup2() {
	System.out.println("After method");
}
@Test
public void mainTest(Method method) {
	System.out.println("Main Test");
	System.out.println("Current method is:"+method.getName());
	System.out.println("Current class is:"+getClass().getSimpleName());
}
}
