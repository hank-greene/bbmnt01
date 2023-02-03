package de.jwic.mobile12.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.Label;
import de.jwic.controls.mobile.MInputBox;
import de.jwic.controls.mobile.MButton;

import de.jwic.mobile12.MobileDemoModule;

import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

import de.jwic.mobile12.BBMNTProperties;
import de.jwic.mobile12.BBMNTConstants;

import java.io.File;
import java.nio.file.Files;

import de.jwic.mobile12.demos.UIDManager;
import de.jwic.mobile12.demos.RandomStringGenerator;
import java.util.HashSet;
import java.util.Hashtable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;

/**
 * Created by boogie on 10/29/14.
 */
public class InputDemo extends MobileDemoModule {

	BBMNTProperties bbmntProps = BBMNTProperties.getInstance();

	UIDManager uidManager = new UIDManager();

	Properties props = new Properties();
	Producer<String, String> producer = null;

	//TODO: read from bbmnt.properties file
	String topicName = "kafkaDev";

	HashSet<String> uids;
	HashSet<String> numbers;
	HashSet<String> addresses;
	Hashtable<String,String> nx;
	Hashtable<String,String> ax;

	File uidsFile = new File("/opt/tomcat/webapps/uids.obj");
	File numbersFile = new File("/opt/tomcat/webapps/numbers.obj");
	File addressesFile = new File("/opt/tomcat/webapps/addresses.obj");
	File nxFile = new File("/opt/tomcat/webapps/nx.obj");
	File axFile = new File("/opt/tomcat/webapps/ax.obj");

	public InputDemo() {
		super("Prospect Link");

		//------------------------------------------------------------------------
		if ( uidsFile.exists() ) {

			try {
				System.out.println( "InputDemo number of uids WTF" );
				uids = uidManager.readUIDHashset( uidsFile );
			} catch ( IOException iox ) {
				iox.printStackTrace();
			} catch ( ClassNotFoundException cnfe ) {
				cnfe.printStackTrace();
			}

			System.out.println( "uids.size " + uids.size() );
			System.out.println( "uids.contains( abc123.xwic )" + uids.contains("abc123.xwic"));

		} else {

			try {
				uids = new HashSet<String>();
				uids.add("abc123.xwic");
			} catch ( Exception ex1 ) {
				System.out.println(ex1.toString());
				ex1.printStackTrace();
			}

			try {
				uidManager.writeUIDHashset(uids, uidsFile);
			} catch ( IOException iox1 ) {
				System.out.println(iox1.toString());
				iox1.printStackTrace();
			}
		}

		//------------------------------------------------------------------------
		if ( numbersFile.exists() ) {

			try {
				numbers = uidManager.readUIDHashset( numbersFile );
			} catch ( IOException iox ) {
				iox.printStackTrace();
			} catch ( ClassNotFoundException cnfe ) {
				cnfe.printStackTrace();
			}

			System.out.println( "numbers.size " + numbers.size() );
			System.out.println( "numbers.contains( 1234567890 )" + uids.contains("1234567890"));

		} else {

			try {
				numbers = new HashSet<String>();
				numbers.add("1234567890");
			} catch ( Exception ex1 ) {
				System.out.println(ex1.toString());
				ex1.printStackTrace();
			}

			try {
				uidManager.writeNUMBERSHashset(numbers, numbersFile);
			} catch ( IOException iox1 ) {
				System.out.println(iox1.toString());
				iox1.printStackTrace();
			}
		}

		//------------------------------------------------------------------------
		if ( addressesFile.exists() ) {

			try {
				addresses = uidManager.readADDRESSHashset( addressesFile );
			} catch ( IOException iox ) {
				iox.printStackTrace();
			} catch ( ClassNotFoundException cnfe ) {
				cnfe.printStackTrace();
			}

			System.out.println( "addresses.size " + addresses.size() );
			System.out.println( "addresses.contains( bob@smith.com )" + uids.contains("bob@smith.com"));

		} else {

			try {
				addresses = new HashSet<String>();
				addresses.add("bob@smith.com");
			} catch ( Exception ex1 ) {
				System.out.println(ex1.toString());
				ex1.printStackTrace();
			}

			try {
				uidManager.writeADDRESSHashset(addresses, addressesFile);
			} catch ( IOException iox1 ) {
				System.out.println(iox1.toString());
				iox1.printStackTrace();
			}
		}

		//------------------------------------------------------------------------
		if ( nxFile.exists() ) {

			try {
				nx = uidManager.readNXHashtable( nxFile );
			} catch ( IOException iox ) {
				iox.printStackTrace();
			} catch ( ClassNotFoundException cnfe ) {
				cnfe.printStackTrace();
			}

			System.out.println( "nx.size " + nx.size() );
			System.out.println( "addresses.contains( 1234567890 )" + nx.get("1234567890"));

		} else {

			try {
				nx = new Hashtable<String,String>();
				nx.put("1234567890","abc123.xwic");
			} catch ( Exception ex1 ) {
				System.out.println(ex1.toString());
				ex1.printStackTrace();
			}

			try {
				uidManager.writeNXHashtable(nx, nxFile);
			} catch ( IOException iox1 ) {
				System.out.println(iox1.toString());
				iox1.printStackTrace();
			}
		}

		//------------------------------------------------------------------------
		//File axFile = new File("/opt/tomcat/webapps/ax.obj");
		if ( axFile.exists() ) {

			try {
				ax = uidManager.readAXHashtable( axFile );
			} catch ( IOException iox ) {
				iox.printStackTrace();
			} catch ( ClassNotFoundException cnfe ) {
				cnfe.printStackTrace();
			}

			System.out.println( "ax.size " + ax.size() );
			System.out.println( "addresses.contains( bob@smith.com )" + nx.get("bob@smith.com"));

		} else {

			try {
				ax = new Hashtable<String,String>();
				ax.put("bob@smith.com","abc123.xwic");
			} catch ( Exception ex1 ) {
				System.out.println(ex1.toString());
				ex1.printStackTrace();
			}

			try {
				uidManager.writeAXHashtable( ax, axFile );
			} catch ( IOException iox1 ) {
				System.out.println(iox1.toString());
				iox1.printStackTrace();
			}
		}		
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		ControlContainer container = new ControlContainer(controlContainer);

		//testSend();
		final Label labelForTextInput = new Label(container, "labelForTextInput");
		labelForTextInput.setText("Enter your Prospect's mobile number or email.");
		
		final MInputBox textInput = new MInputBox(container, "textInput");
		textInput.setText(" ");
		textInput.setClearBtn(true);
		
		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle("Send");
		toggleFromJava.addSelectionListener(new SelectionListener() {
			@Override
			public void objectSelected(SelectionEvent event) {
				System.out.println("Txt or eamil, send a link to a prospect");
				System.out.println(textInput.getText());

				String possible_uid = RandomStringGenerator.get(10);
				possible_uid = possible_uid + ".xwic";
				System.out.println( "possible_uid " + possible_uid );

				while ( uids.contains( possible_uid ) ) {
					possible_uid = RandomStringGenerator.get(10);
					possible_uid = possible_uid + ".xwic";
					System.out.println( "possible_uid " + possible_uid );
				}

				uids.add( possible_uid );

				try {
					uidManager.writeUIDHashset(uids, uidsFile);
				} catch ( IOException iox1 ) {
					System.out.println(iox1.toString());
					iox1.printStackTrace();
				}

				String clean_up_this_uid = possible_uid;

				possible_uid = possible_uid + ".xml";

				String path = "/opt/tomcat/webapps/uid/";
				String abc123 = path + "abc123.xwic.xml";
				String new_uid = path + possible_uid;

				XWICFileGenerator.copyFile( new File( abc123 ), new File( new_uid ) );

				// TODO - much todo here
				String prospectMsg = textInput.getText();

				props.put("bootstrap.servers", "10.10.93.12:9092");
				props.put("acks", "all");
				props.put("retries", 0);
				props.put("batch.size", 16384);
				props.put("linger.ms", 1);
				props.put("buffer.memory", 33554432);
				props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
				props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		
				topicName = "kafkaDev";


				String prospectStr = textInput.getText() + ":" + clean_up_this_uid;


				producer = new KafkaProducer<String, String>(props);
				producer.send( 
					new ProducerRecord<String, String>( topicName, "mobile", prospectStr )
				);
				//producer.send( 
				//	new ProducerRecord<String, String>( topicName, "mobile", textInput.getText() )
				//);
				System.out.println("Message sent");
				producer.close();
				producer = null;
				//        What if the email or number ALREADY as a UID <<<< !!!!!!!!
				/***
				 * 
				 * this implementation is not going to scale, but it starts working
				 * 
				 * DATA GETS WIPED OUT
				 * everytime a new war gets deployed this data gets wiped out
				 * 
				 * 
				 * IDEA number 1
				 * the CURRENT ALGORYTHM
				 *     generate a uuid
				 * 
				 * 	   uuid_exists = true;
				 *     while uuid_exists loop {
				 *        for ( loop throug uids, x++ ) {
				 *             if ( uid[x].contains(uuid) == true) {
				 *             } else {
				 *             }
				 *        }
				 *     }
				 * 
				 * IDEA number 2
				 * if uid_hash_table exists then
				 *    while uid_hash_table.contains( uid ) {
				 *      generate a new uid
				 *    )
				 *    uid_hast_table put uid
				 *    copy file abc123.xwic.xml to uid.xwic.xml
				 * 
				 * else if uid_hash_table does not exists then
				 *    create it?
				 *    or
				 *    pull it from some location
				 * 
				 */ 
				/******
				String uuid = generateUUID();
				System.out.println("uuid = generateUUID() " + uuid);
				while (does_UID_Exist(uuid)) {
					uuid = generateUUID();
				}
				uuid = createNewUID(uuid);
				System.out.println("uuid = createNewUID(uuid) " + uuid);
				uuid = "matt1316.online/samples/mobile12/uid/" + uuid; 
				System.out.println("uuid = textInput.getText() + @ + " + uuid);
				String prospectMsg = textInput.getText() + ":" + uuid;
				 */
			}
		});
		return container;
	}

	//private String generateUUID() {
	//	return UUID.randomUUID().toString().replace("-","");
	//}	

	/****
	 * Horible algorithm!!!!  SEE ABOVE NOTE NUMBER 2 
	 * @param id
	 * @return
	 */
	private boolean does_UID_Exist(String id) {
		boolean result = false;
		File uid = new File("/opt/tomcat/webapps/samples/mobile12/uid");
		File[] uids = uid.listFiles();

		for (int x=0; x<uids.length; x++) {
			if (uids[x].getName().contains(id)==true){
				result = true;
			}
		}
		return result;
	}
	
	/***
	 * 
	 * 
	 * 
	 * @param uid
	 */
	private String createNewUID(String uid) {
		String newUID = uid+".xwic.xml";
		try {
			File source = new File("/opt/tomcat/webapps/samples/mobile12/uid/abc123.xwic.xml");
			File dest = new File("/opt/tomcat/webapps/samples/mobile12/uid/"+newUID);
        	Files.copy(source.toPath(), dest.toPath());
		} catch (Exception ex) {
			System.out.println(ex.toString());
			newUID = "file creation failed";
		}
		newUID = uid + ".xwic";
		return newUID;
	}


	private void setExternalUIDHashsets() {
		
	}

}