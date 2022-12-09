package de.jwic.mobile12.demos;

import de.jwic.mobile12.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;


public class MobileAudioRND extends MobileDemoModule  {

	public MobileAudioRND() {
		super("Mobile Audio RND");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);

        /****
		final Label labelForTextInput = new Label(container, "labelForTextInput");
		labelForTextInput.setText("Prospect mobile or email");
		
		final MInputBox textInput = new MInputBox(container, "textInput");
		textInput.setText(" ");
		textInput.setClearBtn(true);
		
		final Label labelForTextInputWithUpdateOnBlur = 
		             new Label(container, "labelForTextInputWithUpdateOnBlur");
		             
		labelForTextInputWithUpdateOnBlur.setText("Text Input With Mini and Update on Blur");
		
		final Label labelForTextInputWithUpdateOnBlur2 = 
		             new Label(container, "labelForTextInputWithUpdateOnBlur2");

		final MInputBox textInputWithUpdateOnBlur = 
		             new MInputBox(container, "textInputWithUpdateOnBlur");
		textInputWithUpdateOnBlur.setUpdateOnBlur(true);
		textInputWithUpdateOnBlur.setMini(true);
		
		textInputWithUpdateOnBlur.addValueChangedListener(new ValueChangedListener() {
			@Override
			public void valueChanged(ValueChangedEvent event) {
				labelForTextInputWithUpdateOnBlur2.setText(textInputWithUpdateOnBlur.getText());
			}
		});

		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle("Send");
		toggleFromJava.addSelectionListener(new SelectionListener() {
			@Override
			public void objectSelected(SelectionEvent event) {
				System.out.println("Toggle?");
				//checkBox.setChecked(!checkBox.isChecked());
			}
		});
         */
		return container;
	}    
    
}
