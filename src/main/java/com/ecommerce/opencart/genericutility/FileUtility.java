package com.ecommerce.opencart.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream(IConstants.propertyFilePath));
		return prop.getProperty(key);
	}
}
