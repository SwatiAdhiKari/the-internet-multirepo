package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	
	private Properties properties;
	private final String propertyFilePath= "configuration//config.properties";


	public Properties loadProperties() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("commonConfig.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            // Handle the exception appropriately
        }
        return properties;
    }
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = loadProperties();
			
			try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getUser() {
		String user =properties.getProperty("user");
		if(user != null) return user;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	
	}
	public String getPassword() {
		String password =properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	
	}
	
	public String getIncorrectPassword() {
		String password =properties.getProperty("inPassword");
		if(password != null) return password;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	
	}
	
	public String getMessage() {
		String message =properties.getProperty("message");
		if(message != null) return message;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	
	}
}
