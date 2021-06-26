package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configDataProvider {
	
	Properties pro;
	public configDataProvider() throws FileNotFoundException, IOException
	{
		pro=new Properties();
		pro.load(new FileInputStream(new File(System.getProperty("user.dir") +  "/configs/config.properties")));
	}

	
	public String getStagingURL()
	{ return pro.getProperty("stagingURL");// returns the staging URL from config.prop file
	}
	
	

	public String getBrowser()
	{ return pro.getProperty("browser");// returns the browser from the config.properties
	}
	
}
                                                          