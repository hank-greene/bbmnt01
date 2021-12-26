package de.jwic.mobile05.demos;

import de.jwic.events.SelectionListener;
import de.jwic.events.SelectionEvent;

public class AudioSelection implements SelectionListener {
	private String audioTitle = "not set";
	public AudioSelection(){
	}
	public AudioSelection(String t){
		audioTitle = t;
	}
	public void objectSelected(SelectionEvent event){
		System.out.println("objectSelected = "+audioTitle);
	}
	public void setTitle(String t){
		audioTitle = t;
	}
}

