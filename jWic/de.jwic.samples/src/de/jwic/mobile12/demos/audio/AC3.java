package de.jwic.mobile12.demos.audio;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

public class AC3 extends ControlContainer {
	
	private ControlContainer container;
	
	/**
	 * Constructor.
	 * @param parent
	 */
	public AC3 (IControlContainer parent) {
		super(parent);
		internalInit();
	}
	
	/**
	 * Initialize the control itself.
	 */
	private void internalInit() {
		this.container = new ControlContainer(this, "content");
	}
	
	String audioStr = "<h2>Brown Box</br>Motivation</br>and</br>Training</h2>";
	public String getTitle() {
		return audioStr;
	}    
}

