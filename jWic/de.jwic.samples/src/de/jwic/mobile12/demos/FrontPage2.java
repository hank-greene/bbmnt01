package de.jwic.mobile12.demos;

import de.jwic.mobile12.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.jwic.mobile12.demos.audio.AC3;

public class FrontPage2 extends MobileDemoModule  {

	protected transient Log log = LogFactory.getLog(getClass());

    public FrontPage2() {
        super("Front Page");
    }


	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "controlContainer");

		final AC3 audioCtlX = new AC3( container );

		return container;
	}		 
}
