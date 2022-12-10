package de.jwic.mobile12.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.mobile12.MobileDemoModule;

import de.jwic.controls.mobile04.MButton;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.mobile12.demos.audio.AC2;

public class MobileAudioRND extends MobileDemoModule  {

    public MobileAudioRND() {
        super("Mobile Audio RND");
    }

	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "controlContainer");

		final AC2 audioCtl = new AC2( container );
			
        System.out.println("::createPage MobileAudioRND()");

		final MButton toggleFromJava = new MButton(container, "toggleFromJava");
		toggleFromJava.setTitle("Send");
		toggleFromJava.addSelectionListener(new SelectionListener() {
			@Override
			public void objectSelected(SelectionEvent event) {
				System.out.println("Toggle?");
				//checkBox.setChecked(!checkBox.isChecked());
			}
		});


		return container;
	}		 
}
