package de.jwic.mobile05.demos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Stack;

import de.jwic.controls.AnchorLinkControl;
import de.jwic.controls.actions.IAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;

import de.jwic.controls.Label;
import de.jwic.controls.mobile05.MFlipSwitch;


public class EchoWindowList extends ControlContainer {
	
	protected transient Log log = LogFactory.getLog(getClass());
	
	protected List actionOrder = new ArrayList();
	protected Map actionMap = new HashMap();
	
	private Hashtable<Integer,String> keyEchoTbl = new Hashtable<Integer,String>();
	
	private EchoLabel echoLabel;
	private MFlipSwitch flipSwitch;
	
	/*****
	public EchoWindowList( IControlContainer container ) {
		super(container);
		echoList();
	}
	
	public EchoWindowList( IControlContainer container, EchoLabel lbl ) {
		super(container);
		echoLabel = lbl;
		echoList();
	}
	*****/
	
	public EchoWindowList( IControlContainer container, EchoLabel lbl, MFlipSwitch mfs ) {
		super(container);
		echoLabel = lbl;
		flipSwitch = mfs;
		echoList();
	}
	
    public void addAction(IAction action) {
        Integer key = new Integer(action.getTitle());
        actionOrder.add(key);
        actionMap.put(key, action);
    }
	
    public List getActionKeys() {
        return actionOrder;
    }

    public IAction getActionByKey(Integer key) {
    	System.out.println("EchoWindowList.getActionByKey( "+key+" )");
        return (IAction)actionMap.get(key);
    }
	
    public void actionPerformed(String actionId, String parameter) {
    	try {
			System.out.println("EchoWindowList actionPerformed actionId("+
										 actionId+") parameter("+parameter+")");
			String echo = keyEchoTbl.get(new Integer(parameter));
			System.out.println("               "+echo);
			echoLabel.setText( echo );
			flipSwitch.setChecked(!flipSwitch.isChecked());
        } catch(Exception e) {
			System.out.println(e);
		} 
    }
    
	public void echoList(){
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

			System.out.println(" arr.length() "+arr.length());
			
			for (int i = 0; i < arr.length(); i++) {
				System.out.println(" " + arr.get(i));
				addAction(new IndexAction( i, ""+arr.get(i) ));
				//addAction(new AudioButton( ewlContainer, ""+arr.get(i), i ));
				keyEchoTbl.put(new Integer(i), ""+arr.get(i));
			}
		   
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}