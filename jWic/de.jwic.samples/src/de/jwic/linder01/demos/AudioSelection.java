package de.jwic.linder01.demos;

import de.jwic.events.SelectionListener;
import de.jwic.events.SelectionEvent;


public class AudioSelection implements SelectionListener {
	private String audioTitle = "not set";
	private EchoLabel echoLabel = null;
	public AudioSelection(){
	}
	public AudioSelection(String t){
		audioTitle = t;
	}
	public AudioSelection(String t, EchoLabel lbl){
		audioTitle = t;
		echoLabel = lbl;
	}
	public void objectSelected(SelectionEvent event){
		System.out.println("objectSelected = "+audioTitle);
		try {
			echoLabel.setText(audioTitle);
		} catch( Exception ex) {
			System.out.println("AudioSelection.objectSelected "+ex.toString());
		}
	}
	public void setTitle(String t){
		audioTitle = t;
	}
}

