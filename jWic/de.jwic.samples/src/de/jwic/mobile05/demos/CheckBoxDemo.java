package de.jwic.mobile05.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.controls.Label;
import de.jwic.controls.mobile02.IconPos;
import de.jwic.controls.mobile02.MButton;
import de.jwic.controls.mobile02.MCheckBox;

import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;
import de.jwic.events.ValueChangedEvent;
import de.jwic.events.ValueChangedListener;

import de.jwic.mobile05.MobileDemoModule;

/**
 * Created by boogie on 10/30/14.
 */
public class CheckBoxDemo extends MobileDemoModule {

	public CheckBoxDemo() {
		super("CheckBox Demo");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);

		final Label label = new Label(container, "label");
		label.setText("CheckBox is not checked");

		final MCheckBox checkBox = new MCheckBox(container, "checkBox");
		checkBox.setLabel("Toggle Me!");
		checkBox.addValueChangedListener(new ValueChangedListener() {
			
			@Override
			public void valueChanged(ValueChangedEvent event) {
				final boolean state = checkBox.isChecked();
				label.setText("CheckBox is " + (state ? "checked" : "not checked"));
			}
		});
		
		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle("Enable/Disable Mini");
		toggleFromJava.addSelectionListener(new SelectionListener() {
			
			@Override
			public void objectSelected(SelectionEvent event) {
				System.out.println("Toggle?");
				checkBox.setChecked(!checkBox.isChecked());
				if (checkBox.isMini())
					checkBox.setMini(false);
				else
					checkBox.setMini(true);
			}
		});

		return container;
	}
}
