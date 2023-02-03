package de.jwic.mobile12.demos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.BufferedOutputStream;

import java.util.HashSet;
import java.util.Hashtable;

import java.lang.ClassNotFoundException;

import java.io.Serializable;

/***
 *   UIDManager reads and writes the UID hashset to disk.
 *   
 *   On deployment of a new UID.war it
 *      reads the UIDHashset
 *      writes <uid>.xwic.xml files in the uid root dir
 *   so that all previous users can access magneticechos
 * 
 *   maybe UIDManager should be placed somewhere else
 */
public class UIDManager implements Serializable {

    private static final long serialVersionUID = 1L;

    String UIDS_FILE_NAME = "/opt/tomcat/webapps/uids.obj";
    String NUMBERS_FILE_NAME = "/opt/tomcat/webapps/numbers.obj";
    String ADDRESSES_FILE_NAME = "/opt/tomcat/webapps/addresses.obj";
    String NX_FILE_NAME = "/opt/tomcat/webapps/nx.obj";
    String AX_FILE_NAME = "/opt/tomcat/webapps/ax.obj";

    File numbersFile = new File("/opt/tomcat/webapps/numbers.obj");
    File addressesFile = new File("/opt/tomcat/webapps/addresses.obj");
    File nxFile = new File("/opt/tomcat/webapps/nx.obj");
    File axFile = new File("/opt/tomcat/webapps/ax.obj");


    private HashSet<String> uidfile = new HashSet<>();
    private HashSet<String> numbers = new HashSet<>();
    private HashSet<String> addresses = new HashSet<>();
    private Hashtable<String,String> nxfile = new Hashtable<>();
    private Hashtable<String,String> axfile = new Hashtable<>();
    
    
    public UIDManager() {
    }

    // UID

    public HashSet<String> readUIDHashset(File file) throws IOException, ClassNotFoundException {
        HashSet<String> uids = null;
        //try (FileInputStream fis = new FileInputStream(file);
        try (FileInputStream fis = new FileInputStream("/opt/tomcat/webapps/uids.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

                System.out.println( "  UIDManager.readUIDHashSet " + file.toString() );
                System.out.println( "                    canRead " + file.canRead() );
                System.out.println( "                   canWrite " + file.canWrite() );
                System.out.println( "                     exists " + file.exists() );
                System.out.println( "ObjectInputStream available " + ois.available() );

                Object obj = ois.readObject();

                System.out.println(obj.getClass());

                uids = (HashSet<String>)obj;
                //uids = (HashSet) ois.readObject();
                if ( uids == null ) {
                    System.out.println( "UIDManager.readUIDHashSet uids == null" );
                } else {
                    System.out.println( "UIDManager.readUIDHashSet number of uids " + uids.size() );       
                }
                ois.close();
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        return uids;
    }

    public void writeUIDHashset(HashSet hso, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(hso);
                oos.flush();
                //oos.close();
        }
    }

    /***
     * NUMBERS
     * @param file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public HashSet<String> readNUMBERSHashset(File file) throws IOException, ClassNotFoundException {

        HashSet<String> nums = null;
        try (FileInputStream fis = new FileInputStream(NUMBERS_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

                Object obj = ois.readObject();
                System.out.println(obj.getClass());

                nums = (HashSet<String>)obj;
                //uids = (HashSet) ois.readObject();
                if ( nums == null ) {
                    System.out.println( "UIDManager.readNUMBERHashSet uids == null" );
                } else {
                    System.out.println( "UIDManager.readNUMBERHashSet number of uids " + nums.size() );       
                }
                ois.close();
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        return nums;
    }

    public void writeNUMBERSHashset(HashSet nso, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(nso);
                oos.flush();
                //oos.close();
        }
    }


    // addresses
    /*****
     * 
     * @param file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public HashSet<String> readADDRESSHashset(File file) throws IOException, ClassNotFoundException {

        HashSet<String> nums = null;
        try (FileInputStream fis = new FileInputStream(ADDRESSES_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

                Object obj = ois.readObject();
                System.out.println(obj.getClass());

                nums = (HashSet<String>)obj;
                //uids = (HashSet) ois.readObject();
                if ( nums == null ) {
                    System.out.println( "UIDManager.readADDRESSHashSet uids == null" );
                } else {
                    System.out.println( "UIDManager.readADDRESSHashSet number of uids " + nums.size() );       
                }
                ois.close();
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        return nums;
    }

    public void writeADDRESSHashset(HashSet nso, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(nso);
                oos.flush();
                //oos.close();
        }
    }

    // nx
    /**** */
    public Hashtable<String,String> readNXHashtable(File file) throws IOException, ClassNotFoundException {

        Hashtable<String,String> nums = null;
        try (FileInputStream fis = new FileInputStream(NX_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

                Object obj = ois.readObject();
                System.out.println(obj.getClass());

                nums = (Hashtable<String,String>)obj;
                //uids = (HashSet) ois.readObject();
                if ( nums == null ) {
                    System.out.println( "UIDManager.readNXHashtable nx == null" );
                } else {
                    System.out.println( "UIDManager.readNXHashtable number of nx " + nums.size() );       
                }
                ois.close();
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        return nums;
    }

    public void writeNXHashtable(Hashtable nso, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(nso);
                oos.flush();
                //oos.close();
        }
    }

    // ax
    public Hashtable<String,String> readAXHashtable(File file) throws IOException, ClassNotFoundException {

        Hashtable<String,String> nums = null;
        try (FileInputStream fis = new FileInputStream(NX_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

                Object obj = ois.readObject();
                System.out.println(obj.getClass());

                nums = (Hashtable<String,String>)obj;
                //uids = (HashSet) ois.readObject();
                if ( nums == null ) {
                    System.out.println( "UIDManager.readNXHashtable nx == null" );
                } else {
                    System.out.println( "UIDManager.readNXHashtable number of nx " + nums.size() );       
                }
                ois.close();
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        return nums;
    }

    public void writeAXHashtable(Hashtable nso, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(nso);
                oos.flush();
                //oos.close();
        }
    }



}
