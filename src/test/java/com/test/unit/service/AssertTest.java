package com.test.unit.service;

import org.junit.Assert;
import org.junit.Test;

import com.test.unit.entity.User;

public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals(2, 2);
		Assert.assertEquals("Erro de comparação", 2, 2);
		Assert.assertEquals(0.8232, 0.823, .001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i1 = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i1), i2);
		Assert.assertEquals(i1, i2.intValue());
		
		Assert.assertEquals("bola",	"bola");
		Assert.assertNotEquals("bola",	"casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		User u1 = new User("User 1");
		User u2 = new User("User 1");
		User u3 = null;
		
		Assert.assertEquals(u1, u2);
		Assert.assertSame(u2, u2);
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
	}

}
