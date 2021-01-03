package com.test.unit.service;

import com.test.unit.exception.CannotDivideByZeroException;

public class Calculator {

	public int sum(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) throws CannotDivideByZeroException  {
		if(b == 0)	throw new CannotDivideByZeroException();
		return a / b;
	}

}
