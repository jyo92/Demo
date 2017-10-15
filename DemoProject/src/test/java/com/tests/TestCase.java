package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.DemoClass;

public class TestCase 
{
	DemoClass dc = new DemoClass();
	@Test
	public void test1()
	{
		Assert.assertTrue(dc.trueMethod());
	}
	
	@Test
	public void test2()
	{
		Assert.assertTrue(dc.falseMethod());
	}
}
