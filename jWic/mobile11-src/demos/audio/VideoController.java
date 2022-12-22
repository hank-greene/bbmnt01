package de.jwic.mobile11.demos.audio;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.data.ISelectElement;
import de.jwic.base.JavaScriptSupport;

@JavaScriptSupport
public class VideoController extends ControlContainer {
	
	private ControlContainer container;
	private PlayPause playPause;
	
	/**
	 * Constructor.
	 * @param parent
	 */
	public VideoController (IControlContainer parent) {
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
		System.out.println("VideoController.setVideo "+a);
		audioStr = a;
	}
	public String getAudio() {
		System.out.println("Player.setVideo "+"http://localhost:8080/01-amp3s/"+"RDVBuildingTheAmwayBusiness.mp4");
		return "http://localhost:8080/01-amp3s/"+"RDVBuildingTheAmwayBusiness.mp4";
	}
	public String getTitle() {
		return audioStr;
	}
}