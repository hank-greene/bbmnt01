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

/**
 * Created by boogie on 10/29/14.
 */
public class InputDemo extends MobileDemoModule {

	BBMNTProperties bbmntProps = BBMNTProperties.getInstance();

	Properties props = new Properties();
	Producer<String, String> producer = null;
	String topicName = "kafkaDev";

	public InputDemo() {
		super("Prospect Link");
		props.put("bootstrap.servers", "10.10.93.12:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		ControlContainer container = new ControlContainer(controlContainer);

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

				// TODO - much todo here
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


				/**** 
				 * 
				 * 
				 */

				producer = new KafkaProducer<String, String>(props);
				producer.send( 
					new ProducerRecord<String, String>( topicName, "mobile", prospectMsg )
				);
				producer.close();
				producer = null;
			}
		});
		return container;
	}

	private String generateUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}	

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
}