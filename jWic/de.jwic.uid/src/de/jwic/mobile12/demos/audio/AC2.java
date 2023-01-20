package de.jwic.mobile12.demos.audio;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.data.ISelectElement;
import de.jwic.base.JavaScriptSupport;

import de.jwic.mobile12.demos.audio.AC2;

import de.jwic.mobile12.BBMNTProperties;
import de.jwic.mobile12.BBMNTConstants;

@JavaScriptSupport
public class AC2 extends ControlContainer {

	BBMNTProperties bbmntProps = BBMNTProperties.getInstance();
	private ControlContainer container;
	private String media_url = "notset";
	
	/**
	 * Constructor.
	 * @param parent
	 */
	public AC2 (IControlContainer parent) {
		super(parent);
		internalInit();
		media_url = bbmntProps.getValue(BBMNTConstants.MEDIA_URL);
		System.out.println("AC2 "+media_url);
	}
	
	/**
	 * Initialize the control itself.
	 */
	private void internalInit() {
		this.container = new ControlContainer(this, "content");
	}
	
	String audioStr = "select an audio";
	public void setAudio(String a) {
		System.out.println("AudioController.setAudio "+a);
		audioStr = a;
	}
	public String getAudio() {
		String temp = bbmntProps.getValue(BBMNTConstants.MEDIA_URL)+"/01-amp3s/"+audioStr;
		System.out.println(">>>>>> " + temp );
		return temp;
	}
	public String getTitle() {
		return audioStr;
	}    
}
