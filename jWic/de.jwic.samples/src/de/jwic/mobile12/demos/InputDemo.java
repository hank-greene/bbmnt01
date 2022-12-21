package de.jwic.mobile12.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.Label;
import de.jwic.controls.mobile04.MInputBox;
import de.jwic.controls.mobile04.MButton;

import de.jwic.mobile12.MobileDemoModule;

import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

/**
 * Created by boogie on 10/29/14.
 */
public class InputDemo extends MobileDemoModule {

	public InputDemo() {
		super("Prospect Link");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		ControlContainer container = new ControlContainer(controlContainer);

		final Label labelForTextInput = new Label(container, "labelForTextInput");
		labelForTextInput.setText("Enter your Prospect's mobile number or email.");
		
		final MInputBox textInput = new MInputBox(container, "textInput");
		textInput.setText(" ");
		textInput.setClearBtn(true);
		
		final Label labelForTextInputWithUpdateOnBlur = 
		             new Label(container, "labelForTextInputWithUpdateOnBlur");
		             
		labelForTextInputWithUpdateOnBlur.setText("Text Input With Mini and Update on Blur");
		
		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle("Send");
		toggleFromJava.addSelectionListener(new SelectionListener() {
			@Override
			public void objectSelected(SelectionEvent event) {
				System.out.println("Txt or eamil a link to a prospect");
			}
		});

		return container;
	}
}