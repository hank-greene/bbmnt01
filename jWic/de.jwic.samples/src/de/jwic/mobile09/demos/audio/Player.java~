package de.jwic.mobile09.demos.audio;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.base.IResourceControl;
import de.jwic.base.Control;


public class Player extends Control {
	
	private String strAudio = "";
	public Player(IControlContainer parent, String a) {
		super(parent,a);
	}
	public void setAudio(String a) {
		System.out.println("Player.setAudio "+a);
		strAudio = a;
	}
	public String getAudio() {
		System.out.println("Player.setAudio "+"http://localhost:8080/01-amp3s/"+strAudio);
		return "http://localhost:8080/01-amp3s/"+strAudio;
	}
	public String getTitle() {
		return strAudio;
	}
}