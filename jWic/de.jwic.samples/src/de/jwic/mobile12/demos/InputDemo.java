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

import java.util.Properties;;

/**
 * Created by boogie on 10/29/14.
 */
public class InputDemo extends MobileDemoModule {

	Properties props = new Properties();
	Producer<String, String> producer = null;
	String topicName = "kafkaDev";

	public InputDemo() {
		super("Prospect Link");
		props.put("bootstrap.servers", "10.10.89.94:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		//producer = new KafkaProducer<String, String>(props);
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
				producer = new KafkaProducer<String, String>(props);
				producer.send( 
					new ProducerRecord<String, String>(topicName, textInput.getText(), textInput.getText())
				);
				producer.close();
				producer = null;
			}
		});

		return container;
	}
}