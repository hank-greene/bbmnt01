package de.jwic.samples.mechos01.echos01;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.base.ImageRef;
import de.jwic.base.JavaScriptSupport;
import de.jwic.controls.LabelControl;
import de.jwic.controls.actions.IAction;
import de.jwic.controls.HTMLElement;
import de.jwic.controls.SelectableControl;

//public class Echo01 extends HTMLElement {
//public class Echo01 extends SelectableControl {
public class Echo01 extends ControlContainer {
	
	private String echo = "not set";
	private LabelControl echoName = null;
	
	public Echo01(IControlContainer container) {
		super (container, null);
	}
	
	public Echo01(IControlContainer container, String name) {
		super (container, name);
		this.setTemplateName("de.jwic.samples.mechos01.echo01.Echo01");
		//echoName = new LabelControl(container, "echoName");
		echoName = new LabelControl(this, "echoName");
	}
	
	public void setEcho(String e) {
		//echo = e;
		System.out.println("Echo01.setEcho "+e);
		echoName.setText( e );
	}
	
	public String getEcho() {
		return echoName.getText();
	}
}