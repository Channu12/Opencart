package com.ecommerce.opencart.usermodule;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.opencart.genericutility.BaseClass;

@Listeners(com.ecommerce.opencart.genericutility.LisImpClass.class)
public class LoginToAppTest extends BaseClass{

	@Test
	public void loginToAppTest()
	{
		System.out.println("Logged In");
	}
	
	@Test
	public void logoutFromAppTest()
	{
		System.out.println("Logged out");
		Assert.fail();
	}
}
