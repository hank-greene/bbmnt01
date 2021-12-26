package de.jwic.samples.mechos01;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.base.Page;
import de.jwic.base.SessionContext;

import de.jwic.controls.Button;
import de.jwic.controls.LabelControl;
import de.jwic.controls.ScrollableContainer;

import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

import de.jwic.samples.mechos01.echos01.Echo01;
import de.jwic.samples.mechos01.echos01.AudioButton;

public class Mechos01 extends Application {

	private LabelControl label = null;
	private int value = 0;
	private Echo01 echo = null;

	public Control createRootControl(IControlContainer container) {
		Page page = new Page(container);
		page.setTitle("MagneticEchos");
		
		SessionContext sc = this.getSessionContext();
		HashMap initParams = (HashMap)sc.getInitParameters();
		Set keys = initParams.keySet();
		System.out.println("-----.  session context key count "+keys.size());
		for ( Iterator i = keys.iterator(); i.hasNext(); ) {
			String key = (String)i.next();
			String[] kValue = (String[])initParams.get(key);
			System.out.println(" key("+key+") name[0]"+kValue[0]);
		}
		
		// Specify a template for our sample. The template name usualy contains 
		// the full package-name and a resource name.  A similar code would look
		// like this: page.setTemplateName(getClass().getName());
		page.setTemplateName("de.jwic.samples.mechos01.Mechos01");
		
		label = new LabelControl(page, "label");
		label.setText("0");

		Button btInc = new Button(page, "btInc");
		btInc.setTitle("Increase");
		btInc.addSelectionListener(new SelectionListener() {
			public void objectSelected(SelectionEvent event) {
				modify(1);
			}
		});

		Button btDec = new Button(page, "btDec");
		btDec.setTitle("Decrease");
		btDec.addSelectionListener(new SelectionListener() {
			public void objectSelected(SelectionEvent event) {
				modify(-1);
			}
		});

		Button select01 = new Button(page, "selector01");
		select01.setTitle("tape one");
		select01.addSelectionListener(new SelectionListener() {
			public void objectSelected(SelectionEvent event) {
				//playTape("Gooche Family Reunion");
				System.out.println("button 1 Mechos01.objectSelected event "+event.toString());
				playTape("\"http://localhost:8080/amp3s/jc-gooch-side-1.mp3\"");
				echo.requireRedraw();
			}
		});
	
	
		Button select02 = new Button(page, "selector02");
		select02.setTitle("tape two");
		select02.addSelectionListener(new SelectionListener() {
			public void objectSelected(SelectionEvent event) {
				System.out.println("button 2 Mechos01.objectSelected event "+event.toString());
				playTape("\"http://localhost:8080/amp3s/1987-edification.mp3\"");
				echo.requireRedraw();
			}
		});

		
		AudioButton aButton = new AudioButton(page, "audioButton");
		aButton.setTitle("Audio Button");
		aButton.setAudioLink("http://localhost:8080/amp3s/jc-gooch-side-1.mp3");
		aButton.addSelectionListener(new SelectionListener(){
			public void objectSelected(SelectionEvent event) {
				System.out.println("AudioButton Mechos01.objectSelected event "+event.toString());
			}
		});
		
		String media01Str = "media01";
		String media01Title = "jc-gooch-side-1";
		
		AudioButton media01 = new AudioButton( page, media01Str );
		media01.setTitle( media01Title );
		media01.setAudioLink("http://localhost:8080/amp3s/" + media01Title + ".mp3");
		media01.addSelectionListener(new SelectionListener(){
			public void objectSelected(SelectionEvent event) {
				System.out.println("AudioButton Mechos01.objectSelected event "+event.toString());
			}
		});
		
		echo = new Echo01(page, "echo");
		
		return page;
	}

	/**
	 * Modify the current value and update the label.
	 * @param i
	 */
	protected void modify(int i) {

		value += i;
		label.setText(Integer.toString(value));
		
	}
	
	protected void playTape(int i) {
		label.setText(Integer.toString(i));
	}
	
	protected void playTape(String n) {
		//label.setText( n );
		System.out.println("Mechos01.playTape "+n);
		echo.setEcho( n );
		//echo.click();
	}
	
	public void preDestroy() {
		System.out.println("WebSite.preDestroy()");
	}

}
