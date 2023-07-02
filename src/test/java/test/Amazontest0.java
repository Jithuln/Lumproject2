package test;

import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;


import page.Amazon0;



public class Amazontest0 extends Amazonbase0 {
	@Test
	public void amazon() throws Exception
	{
		Amazon0 a= new Amazon0(driver);
		a.search();
		a.filter();
		a.phone();
		a.sign();
		String currenturl=driver.getCurrentUrl();
		URL g=new URL(currenturl);
		HttpURLConnection ur=(HttpURLConnection)g.openConnection();
		ur.connect();
		int response=ur.getResponseCode();
		System.out.println("Responsecode:"+response);
		System.out.println("Responsemessage:"+ur.getResponseMessage());
		Assert.assertEquals(response,404,503);
		System.out.println("Error,Login failed");
		
	}

}
