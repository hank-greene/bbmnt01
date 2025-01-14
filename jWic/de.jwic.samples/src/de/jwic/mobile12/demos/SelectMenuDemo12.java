package de.jwic.mobile12.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.mobile.MSelectmenu;
import de.jwic.data.ISelectElement;
import de.jwic.mobile12.MobileDemoModule;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author vedad
 *
 */
public final class SelectMenuDemo12 extends MobileDemoModule {

	/**
	 * @param title
	 */
	public SelectMenuDemo12() {
		super("Magnetic Echo List");
	}

	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "controlContainer");
		
		MSelectmenu selectmenu = new MSelectmenu(container, "selectmenu");
		selectmenu.setCorners(false);
		
		ISelectElement firstone = selectmenu.addElement("init-item", "select an echo");
		selectmenu.setSelectedElement(firstone);
		
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
			
			for (int i = 0; i < arr.length(); i++) {
				System.out.println(" " + arr.get(i));
				selectmenu.addElement(""+arr.get(i), ""+i+"-"+arr.get(i));
			}
		   
		} catch(Exception e) {
			System.out.println(e);
		}
				
		return container;
	}

}