package com.atmecs;

public class Constants {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	public final static String configpath = PROJECT_BASE_PATH + "/resources/Config.properties";
	public final static String locator_path = PROJECT_BASE_PATH + "/resources/locator_path.properties";
	public final static String testdata_path= PROJECT_BASE_PATH + "/resources/testdata.properties";
	public final static String chromepath =PROJECT_BASE_PATH + "/lib/chd.exe";
	public final static String ffpath =PROJECT_BASE_PATH + "/lib/geckodriver.exe";
	public final static String iepath =PROJECT_BASE_PATH + "/lib/IEDriverServer.exe";
	
}
