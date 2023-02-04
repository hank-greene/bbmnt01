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

import de.jwic.mobile12.BBMNTProperties;
//import de.jwic.mobile12.BBMNTConstants;

import java.io.File;
//import java.nio.file.Files;

//import de.jwic.mobile12.demos.UIDManager;
//import de.jwic.mobile12.demos.RandomStringGenerator;
import java.util.HashSet;
import java.util.Hashtable;
import java.io.IOException;
//import java.io.FileNotFoundException;
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


	File uidsFile = new File("/opt/tomcat/webapps/uids.obj");
	File numbersFile = new File("/opt/tomcat/webapps/numbers.obj");
	File addressesFile = new File("/opt/tomcat/webapps/addresses.obj");
	File nxFile = new File("/opt/tomcat/webapps/nx.obj");
	File axFile = new File("/opt/tomcat/webapps/ax.obj");

	HashSet<String> uids;
	HashSet<String> numbers = UIDManager.getNUMBERSHashset();   
	HashSet<String> addresses;
	Hashtable<String,String> nx;
	Hashtable<String,String> ax;

	public InputDemo() {
		super("Prospect Link");
		setExternalUIDHashsets();
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		ControlContainer container = new ControlContainer(controlContainer);

		System.out.println("numbers = UIDManager.getNUMBERSHashset();");
		numbers = UIDManager.getNUMBERSHashset();   

		final Label labelForTextInput = new Label(container, "labelForTextInput");
		labelForTextInput.setText("Enter your Prospect's mobile number or email.");
		
		final MInputBox textInput = new MInputBox(container, "textInput");
		textInput.setText(" ");
		textInput.setClearBtn(true);
		
		final Label labelNotes = new Label(container, "labelNotes");
		labelNotes.setText("Add a note to remember them, e.g. name, or whatever.");

		final MInputBox textNote = new MInputBox(container, "textNote");
		textNote.setText(" ");
		textNote.setClearBtn(true);

		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle( "Send" );

		final Label labelSendResult = new Label(container, "labelMSGSent");
		labelSendResult.setText("<br/>");

		toggleFromJava.addSelectionListener(new SelectionListener() {
			@Override
			public void objectSelected(SelectionEvent event) {

				String sendResultMsg = "not set";

				System.out.println("Txt or eamil, send a link to a prospect");
				System.out.println(textInput.getText().trim());
				String mobile_num = textInput.getText().trim();

				System.out.println( "numbers file exists " + numbersFile.exists() );
				System.out.println( "numbers.contains( " + mobile_num.trim() + " ) " + numbers.contains( mobile_num ) );

				if ( numbers.contains( mobile_num.trim() ) ) {

					System.out.println(" " + mobile_num + " has a link " + numbers.contains( mobile_num.trim() ) );
					System.out.println("            " + nx.get( mobile_num ) );
					sendResultMsg = mobile_num + " has account, " + nx.get( mobile_num.trim() ) + 
					                          ". Link sent.";

					String clean_up_this_uid = nx.get( mobile_num.trim() );

					String prospectStr = textInput.getText() + ":" + clean_up_this_uid + ".xwic";
					push_mobile_and_uid_onto_kafka_channel( prospectStr );

				} else {

					String possible_uid_str = RandomStringGenerator.get(10);
					String possible_uid = possible_uid_str + ".xwic";
					System.out.println( "possible_uid " + possible_uid );

					while ( uids.contains( possible_uid ) ) {
						possible_uid_str = RandomStringGenerator.get(10);
						possible_uid = possible_uid_str + ".xwic";
					}

					uids.add( possible_uid_str );
					numbers.add( mobile_num.trim() );
					nx.put( mobile_num, possible_uid_str );
					// address.add ( email_address );
					// ax.put ( email_address, possible_uid_str );

					try {
						uidManager.writeUIDHashset( uids, uidsFile );
						uidManager.writeNUMBERSHashset( numbers, numbersFile );
						uidManager.writeNXHashtable( nx, nxFile );
						// uidManager.writeNUMBERSHashset( numbers, numbersFile );
						// uidManager.writeAXHashtable( ax, axFile );
					} catch ( IOException iox1 ) {
						System.out.println( iox1.toString() );
						iox1.printStackTrace();
					}

					String clean_up_this_uid = possible_uid;
					possible_uid = possible_uid + ".xml";

					String path = "/opt/tomcat/webapps/uid/";
					String abc123 = path + "abc123.xwic.xml";
					String new_uid = path + possible_uid;

					XWICFileGenerator.copyFile( new File( abc123 ), new File( new_uid ) );

					String prospectStr = textInput.getText() + ":" + clean_up_this_uid;

					push_mobile_and_uid_onto_kafka_channel( prospectStr );

					// TODO - much todo here
					//String prospectMsg = textInput.getText();
					/*****
					props.put("bootstrap.servers", "10.10.93.12:9092");
					props.put("acks", "all");
					props.put("retries", 0);
					props.put("batch.size", 16384);
					props.put("linger.ms", 1);
					props.put("buffer.memory", 33554432);
					props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
					props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
			
					topicName = "kafkaDev";

					producer = new KafkaProducer<String, String>(props);
					producer.send( 
						new ProducerRecord<String, String>( topicName, "mobile", prospectStr )
					);
					 */
					//producer.send( 
					//	new ProducerRecord<String, String>( topicName, "mobile", textInput.getText() )
					//);

					System.out.println("Message sent");
					producer.close();
					producer = null;

					sendResultMsg = " User ID, " + possible_uid_str + ", sent to " + mobile_num + ".";

				} 

				textInput.setText(" ");
				labelSendResult.setText( sendResultMsg );

			}
		});

		return container;
	}


	private void push_mobile_and_uid_onto_kafka_channel( String muid ) {

		props.put("bootstrap.servers", "10.10.93.12:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

		topicName = "kafkaDev";

		producer = new KafkaProducer<String, String>(props);
		producer.send( 
			new ProducerRecord<String, String>( topicName, "mobile", muid )
		);

	}
	
	private void setExternalUIDHashsets() {

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
}