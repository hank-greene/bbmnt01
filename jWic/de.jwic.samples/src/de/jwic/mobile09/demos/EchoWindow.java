package de.jwic.mobile09.demos;

import de.jwic.mobile09.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.controls.ScrollableContainer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.jwic.controls.Label;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Enumeration;

import de.jwic.controls.AnchorLinkControl;
import de.jwic.controls.actions.IAction;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

import de.jwic.controls.mobile06.MFlipSwitch;
import de.jwic.events.ValueChangedEvent;
import de.jwic.events.ValueChangedListener;

//---------------------------------------------------------------------
import de.jwic.controls.layout.TableLayoutContainer;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.controls.mobile04.MButton;
import de.jwic.controls.mobile08.MCheckBox;
import de.jwic.controls.mobile08.MTransitionBox;

//---------------------------------------------------------------------
import de.jwic.mobile09.demos.audio.Player;

public class EchoWindow extends MobileDemoModule {
	
    protected transient Log log = LogFactory.getLog(getClass());
    
	private EchoLabel label;
    
	public EchoWindow() {
		super("Echo Window");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);
		
		final Player audio = new Player(container, "audio");
		
		final MCheckBox checkBox = new MCheckBox(container, "checkBox");
		checkBox.setLabel("select V");
		
		final ScrollableContainer sc = new ScrollableContainer(container);
		sc.setHeight("350px");
		sc.setWidth("300px");
		
		//sc.setTemplateName(getClass().getName()+"_group");
		TableLayoutContainer tlc = new TableLayoutContainer(sc, "table");
		tlc.setColumnCount(1);

		try {
			
		    String url = "http://localhost:8080/01-amp3s/01-amp3s.json";
		    URL obj = new URL(url);
		    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		    int responseCode = con.getResponseCode();
		    System.out.println("\nSending 'GET' request to URL : " + url);
		    System.out.println("Response Code : " + responseCode);
		    BufferedReader in =new BufferedReader(
		    new InputStreamReader(con.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();
		    while ((inputLine = in.readLine()) != null) {
			  response.append(inputLine);
		    } in .close();
		    //print in String
		    System.out.println(response.toString());
		    JSONObject myresponse = new JSONObject(response.toString());
		   
			JSONArray arr = myresponse.getJSONArray("echo-list");
			
			AudioButton[] arrayOButtons = new AudioButton[arr.length()];
			
			for (int i = 0; i < arr.length(); i++) {
				System.out.println(" " + arr.get(i));
				arrayOButtons[i] = new AudioButton(tlc);
				//--------------
				// I don't like the label being passed into the construtor
				// but whatever
				
				//arrayOButtons[i].addSelectionListener(
				//	    (new AudioSelection(""+arr.get(i), label, checkBox)));
				arrayOButtons[i].addSelectionListener(
					    (new AudioSelection(""+arr.get(i), null, checkBox, audio)));
				//--------------------------------
				arrayOButtons[i].addSelectionListener(new SelectionListener(){
					@Override
					public void objectSelected(SelectionEvent event) {
						System.out.println("++++++++++++++++objectSelected");
						System.out.println("                "+event.toString());
					}
				});
				arrayOButtons[i].setTitle(""+arr.get(i));
				arrayOButtons[i].setAudioLink("http://localhost:8080/01-amp3s/"+arr.get(i));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return container;
	}

}