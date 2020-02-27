package com.testproject.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) throws IOException {


	String projectDir = System.getProperty("user.dir");
	Properties config = new Properties();
	Properties OR = new Properties();

	FileInputStream fis = new FileInputStream(projectDir + "//src//test//resources//com//testproject//properties//Config.properties");
	config.load(fis);
	
	fis = new FileInputStream(projectDir + "//src//test//resources//com//testproject//properties//OR.properties");
	OR.load(fis);
	
	System.out.println(config.getProperty("browser"));
	System.out.println(OR.getProperty("bmlBtn"));
	}

}
