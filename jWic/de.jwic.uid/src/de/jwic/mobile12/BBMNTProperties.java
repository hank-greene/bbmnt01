package de.jwic.mobile12;

import java.io.Serializable;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

import java.io.File;

public class BBMNTProperties implements Serializable {

    private static BBMNTProperties instance = null;
    private static Properties props;

    private BBMNTProperties(){
        try {

            System.out.println(">_>_>_>_>_> properties file located "+"/opt/tomcat/webapps/uid/bbmnt.properties");

            props = new Properties();
            FileInputStream fis = new FileInputStream("/opt/tomcat/webapps/uid/bbmnt.properties");
            props.load(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static BBMNTProperties getInstance(){
        if (instance == null){
            instance = new BBMNTProperties();
        }
        return instance;
    }

    public String getValue(String key) {
        return props.getProperty(key);
    }
    
}
