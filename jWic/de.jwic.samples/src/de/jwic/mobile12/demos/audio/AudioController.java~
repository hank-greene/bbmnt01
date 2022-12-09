package de.jwic.mobile10.demos.audio;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.data.ISelectElement;
import de.jwic.base.JavaScriptSupport;

@JavaScriptSupport
public class AudioController extends ControlContainer {
	
	private ControlContainer container;
	private PlayPause playPause;
	
	/**
	 * Constructor.
	 * @param parent
	 */
	public AudioController (IControlContainer parent) {
		super(parent);
		internalInit();
	}
	
	/**
	 * Initialize the control itself.
	 */
	private void internalInit() {
		this.container = new ControlContainer(this, "content");
	}
	
	String audioStr = "not set";
	public void setAudio(String a) {
		System.out.println("AudioController.setAudio "+a);
		audioStr = a;
	}
	public String getAudio() {
		System.out.println("Player.setAudio "+"http://localhost:8080/01-amp3s/"+audioStr);
		return "http://localhost:8080/01-amp3s/"+audioStr;
	}
	public String getTitle() {
		return audioStr;
	}
}