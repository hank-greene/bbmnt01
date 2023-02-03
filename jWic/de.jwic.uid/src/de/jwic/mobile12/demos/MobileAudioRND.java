package de.jwic.mobile12.demos;

import de.jwic.mobile12.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.mobile12.demos.audio.AC2;

import de.jwic.controls.layout.TableLayoutContainer;
import de.jwic.controls.ScrollableContainer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONArray;

import de.jwic.mobile12.BBMNTProperties;
import de.jwic.mobile12.BBMNTConstants;

public class MobileAudioRND extends MobileDemoModule  {

	protected transient Log log = LogFactory.getLog(getClass());

	BBMNTProperties bbmntProps = BBMNTProperties.getInstance();

    public MobileAudioRND() {
        super("Magnetic Echos");
    }

	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "controlContainer");

		final AC2 audioCtlX = new AC2( container );
		
		final ScrollableContainer sc = new ScrollableContainer(container);
		sc.setHeight("350px");
		sc.setWidth("300px");
		
		TableLayoutContainer tlc = new TableLayoutContainer(sc, "table");
		tlc.setColumnCount(1);

		try {
			
			String url = bbmntProps.getValue(BBMNTConstants.MEDIA_URL)+"/01-amp3s/01-amp3s.json";
		    URL obj = new URL(url);
		    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		    int responseCode = con.getResponseCode();
		    System.out.println("\nSending 'GET' request to URL : " + url);
		    System.out.println("Response Code : " + responseCode);

		    BufferedReader in =new BufferedReader( new InputStreamReader(con.getInputStream()) );
		    String inputLine;
		    StringBuffer response = new StringBuffer();
		    while ((inputLine = in.readLine()) != null) {
			  response.append(inputLine);
		    } 
			in .close();
		    //print in String
		    System.out.println(response.toString());

		    JSONObject myresponse = new JSONObject(response.toString());
			JSONArray arr = myresponse.getJSONArray("echo-list");
			
			AudioButton[] arrayOButtons = new AudioButton[arr.length()];
			
			for (int i = 0; i < arr.length(); i++) {
				System.out.println(" " + arr.get(i));
				arrayOButtons[i] = new AudioButton(tlc);
				//--------------------------------
				arrayOButtons[i].addSelectionListener(
					    (new AudioSelection2(""+arr.get(i),audioCtlX)));
				//--------------------------------
				arrayOButtons[i].addSelectionListener(new SelectionListener(){
					@Override
					public void objectSelected(SelectionEvent event) {
						System.out.println("++++++++++++++++objectSelected");
						System.out.println("                "+event.toString());
						container.requireRedraw();
					}
				});
				arrayOButtons[i].setTitle(""+arr.get(i));
				arrayOButtons[i].setAudioLink(bbmntProps.getValue(BBMNTConstants.MEDIA_URL)+"/01-amp3s/"+arr.get(i));
			}

		} catch(Exception e){
			System.out.println(e.toString());
			log.debug(e.toString());
		}

		return container;
	}		 
}