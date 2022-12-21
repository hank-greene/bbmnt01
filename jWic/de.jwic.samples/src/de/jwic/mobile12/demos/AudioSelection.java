package de.jwic.mobile12.demos;

import de.jwic.events.SelectionListener;
import de.jwic.events.SelectionEvent;
import de.jwic.controls.mobile08.MCheckBox;

import de.jwic.mobile12.demos.audio.AudioController;

public class AudioSelection implements SelectionListener {
	
	private String    audioTitle = " ";
	private AudioController audioCtl = null;
	
	//public AudioSelection(String t, EchoLabel lbl, MCheckBox ckbx, AudioController ac){
	//	audioTitle = t;
	//	audioCtl = ac;
	//}
	
	public AudioSelection(String t, MCheckBox ckbx, AudioController ac){
		audioTitle = t;
		audioCtl = ac;
	}

	public void objectSelected(SelectionEvent event){
		System.out.println("objectSelected = "+audioTitle);
		try {
			audioCtl.setAudio(audioTitle);
			audioCtl.requireRedraw();
		} catch( Exception x2 ) {
			System.out.println("AudioSelection.objectSelected "+x2.toString());
		}
	}
	
	public void setTitle(String t){
		audioTitle = t;
	}
}