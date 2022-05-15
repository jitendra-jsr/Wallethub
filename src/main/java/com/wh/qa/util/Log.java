package com.wh.qa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class Log {

	public static Logger log = LogManager.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName)
	{
		log.info("==========="+sTestCaseName+" Test Start ==========");
	}
	
	public static void endTestCase(String sTestCaseName)
	{
		log.info("==========="+sTestCaseName+" Test Start ==========");
	}
	
	public static void info(String message)
	{
		log.info(message);
	}
	
	public static void warn(String message)
	{
		log.warn(message);
	}
	
	public static void error(String message)
	{
		log.warn(message);
	}
	
	public static void fatal(String message)
	{
		log.warn(message);
	}
	
}
