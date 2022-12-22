package de.jwic.mobile05.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.Label;
import de.jwic.controls.mobile.MButton;

import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.mobile05.MobileDemoModule;

/**
 * Created by boogie on 10/30/14.
 */
public class FlipSwitchDemo extends MobileDemoModule {

	private Label label;

	public FlipSwitchDemo() {
		super("FlipSwitch Demo");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);

		label = new Label(container, "label");
		label.setText("");

		
		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle("Toggle From Java");
		toggleFromJava.addSelectionListener(new SelectionListener() {
			
			@Override
			public void objectSelected(SelectionEvent event) {
				System.out.println("Toggle?");
			}
		});

		return container;
	}
}
