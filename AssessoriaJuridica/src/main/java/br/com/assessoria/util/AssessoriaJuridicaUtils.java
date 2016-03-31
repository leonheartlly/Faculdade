package br.com.assessoria.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AssessoriaJuridicaUtils {
	private static final Logger LOGGER = Logger.getLogger(AssessoriaJuridicaUtils.class.getName());
	private static final String baseDir = new File("").getAbsolutePath();
//	private static final String ASSESSORIA_PROPERTIES_FILE_PATH =  baseDir + File.separator + "conf" + File.separator + "assessoria.properties";
	private static final String ASSESSORIA_PROPERTIES_FILE_PATH = "/opt/assessoria/conf/assessoria.properties";
	
	
	public static String getProperty(String propertyName) {

		Properties propertyFile = new Properties();
		String propertyValue = null;
		FileInputStream assessoria = null;
		try {
			assessoria = new FileInputStream(ASSESSORIA_PROPERTIES_FILE_PATH);
			propertyFile.load(assessoria);
			propertyValue = propertyFile.getProperty(propertyName);
		} catch (IOException e) {
			LOGGER.error("Exception occurred on AuditInventory.getProperty(): " + e);
		} finally {
			try {
				assessoria.close();
			} catch (IOException e) {
				LOGGER.error("Error closing file on AuditInventory.getProperty(): "	+ e);
			}
		}
		return propertyValue;
	}
}
