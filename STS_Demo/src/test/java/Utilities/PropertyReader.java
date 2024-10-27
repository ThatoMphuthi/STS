package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader(){
        loadProperties();
    }

    public static Properties properties;

    public void loadProperties(){
        properties = new Properties();
        try{
            String path = "Models/ApplicationModel.properties";
            properties.load(new FileInputStream(path));
            System.out.println("File found");
        }catch(IOException e){
            throw new RuntimeException("File Not Found");
        }
    }

    public static String readItem(String pName){
        return properties.getProperty(pName);
    }

}
