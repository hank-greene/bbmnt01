package de.jwic.mobile12.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.mobile12.MobileDemoModule;

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
			
        System.out.println("::createPage MobileAudioRND()");


		return container;
	}		 
}
