package test.day9_testbase_properties_driverUtilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public  void reading_properties_file() throws IOException {
        //properties class object allows us
        //to read from configuration.properties
        Properties properties=new Properties();

        //We need to show where the file is stored
        //we need the path of the file

        String path="configuration.properties";

        //We need to open this configuration.properties file in java memory

        FileInputStream file =new FileInputStream(path);

        //we need to load the opened file into the properties object

        properties.load(file);

        //We can read the configuration.properties file using properties object

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
    }

    @Test
    public void using_configuration_reader_utility(){
        String browser=ConfigurationReader.getProperty("browser");
        System.out.println("browser= "+browser);

        String username=ConfigurationReader.getProperty("username");
        System.out.println("username: "+username);
    }
}
