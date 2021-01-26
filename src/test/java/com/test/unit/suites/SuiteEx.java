package com.test.unit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.unit.service.CalculationOfRentValueTest;
import com.test.unit.service.CalculatorTest;
import com.test.unit.service.RentServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	CalculatorTest.class,
	CalculationOfRentValueTest.class,
	RentServiceTest.class
})
public class SuiteEx {

}
