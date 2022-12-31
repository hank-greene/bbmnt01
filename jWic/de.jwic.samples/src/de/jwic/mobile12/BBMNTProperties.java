package de.jwic.mobile12;

import de.jwic.base.JWicRuntime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BBMNTProperties {

    private static BBMNTProperties bbmntProps = null;

    private BBMNTProperties(){}

    public static BBMNTProperties getInstance(){

        String contextPath = JWicRuntime.getJWicRuntime().getContextPath();
        System.out.println(" contextPath "+contextPath);
        System.out.println("    rootPath "+JWicRuntime.getJWicRuntime().getRootPath());
        try (InputStream input = new FileInputStream(JWicRuntime.getJWicRuntime().getRootPath()+"bbmnt.properties")) {

            Properties props = new Properties();
            props.load(input);
            System.out.println(props.getProperty("kafkaIP"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        if (bbmntProps == null){
            bbmntProps = new BBMNTProperties();
        }
        return bbmntProps;
    }
    
}
