package de.jwic.mobile12;

import java.io.Serializable;
import de.jwic.base.JWicRuntime;

import java.io.IOException;
import java.util.Properties;

public class BBMNTProperties implements Serializable {

    private static BBMNTProperties instance = null;
    private static Properties props;

    private BBMNTProperties(){
    }

    public BBMNTProperties getInstance(){
        /****
        if (instance == null){
            try {
                props = new Properties();
                props.load(getClass().getResourceAsStream(JWicRuntime.getJWicRuntime().getRootPath()+"bbmnt.properties"));
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
            instance = new BBMNTProperties();
        }
         */
        return instance;
    }

    public String getValue(String key) {
        return props.getProperty(key);
        //return "not set";
    }
    
}
