package com.test.unit.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.test.unit.exception.CannotDivideByZeroException;

public class CalculatorTest {

	Calculator c;
	
	@Before
	public void initial() {
		c = new Calculator();
	}
	
	@Test
	public void sumTwoValues() {
		// scenario
		int a = 5;
		int b = 3;
		
		// action
		int result = c.sum(a, b);
		
		// verify
		assertEquals(8, result);
	}
	
	@Test
	public void subtractTwoValues() {
		// scenario
		int a = 19;
		int b = 7;
		
		// action
		int result = c.subtract(a, b);
		
		// verify
		assertEquals(12, result);
	}
	
	@Test
	public void divideTwoValues() throws CannotDivideByZeroException {
		// scenario
		int a = 12;
		int b = 2;
		
		// action
		int result = c.divide(a, b);
		
		// verify
		assertEquals(6, result);
	}
	
	@Test(expected = CannotDivideByZeroException.class)
	public void cannotDivideByZero() throws CannotDivideByZeroException {
		// scenario
		int a = 4;
		int b = 0;

		// action
		c.divide(a, b);
	}
	
}
