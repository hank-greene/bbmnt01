package de.jwic.mobile12.demos;

import de.jwic.controls.HTMLElement;
import de.jwic.base.IControlContainer;

public class EchoLabel extends HTMLElement {
	
	private static final long serialVersionUID = 1L;

	private String strText = "";

	/**
	 * @param container
	 */
	public EchoLabel(IControlContainer container) {
		super(container, null);
	}
	
	/**
	 * @param container
	 * @param name
	 */
	public EchoLabel(IControlContainer container, String name) {
		super(container, name);
	}
	
	/**
	 *
	 * @return java.lang.String
	 */
	public String getText() {
		return strText;
	}
	
	/**
	 *
	 * @param newText java.lang.String
	 */
	public void setText(String newText) {
		strText = newText;
		setRequireRedraw(true);
	}
		
}