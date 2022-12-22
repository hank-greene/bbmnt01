package de.jwic.mobile09.demos;

import de.jwic.events.SelectionListener;
import de.jwic.events.SelectionEvent;
//import de.jwic.controls.mobile08.MCheckBox;

import de.jwic.mobile09.demos.audio.Player;

public class AudioSelection implements SelectionListener {
	private String    audioTitle = "not set";
	private EchoLabel echoLabel = null;
	private Player    player = null;
	public AudioSelection(String t, Player p){
		audioTitle = t;
		player = p;
	}
	public void objectSelected(SelectionEvent event){
		System.out.println("objectSelected = "+audioTitle);
		try {
			player.setAudio(audioTitle);
			player.requireRedraw();
		} catch( Exception x2 ) {
			System.out.println("AudioSelection.objectSelected "+x2.toString());
		}
	}
	public void setTitle(String t){
		audioTitle = t;
	}
}