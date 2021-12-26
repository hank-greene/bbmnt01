package de.jwic.mobile05.demos;

import de.jwic.mobile05.MobileDemoModule;
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

import de.jwic.controls.mobile05.MFlipSwitch;
import de.jwic.events.ValueChangedEvent;
import de.jwic.events.ValueChangedListener;

//---------------------------------------------------------------------
import de.jwic.controls.layout.TableLayoutContainer;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

public class EchoWindow extends MobileDemoModule {
	
    protected transient Log log = LogFactory.getLog(getClass());
    
	private EchoLabel label;
    
	public EchoWindow() {
		super("Echo Window");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);
		
		final MFlipSwitch checkBox = new MFlipSwitch(container, "checkBox");
		checkBox.addValueChangedListener(new ValueChangedListener() {
			
			@Override
			public void valueChanged(ValueChangedEvent event) {
				final boolean state = checkBox.isChecked();
				label.setText("FlipSwitch is " + (state ? "checked" : "not checked"));
			}
		});
		
		label = new EchoLabel(container, "label");
		label.setText("Magnetic Echo");
		
		System.out.println("=====> class name "+getClass().getName()+"  <======================================");
		ScrollableContainer sc = new ScrollableContainer(container);
		sc.setHeight("250px");
		sc.setWidth("250px");
		
		EchoWindowList ewList = new EchoWindowList( sc, label, checkBox );
		
		return container;
	}

}