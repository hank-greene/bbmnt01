package de.jwic.mobile11.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.data.ISelectElement;
import de.jwic.mobile11.MobileDemoModule;

import de.jwic.mobile11.demos.audio.VideoController;

/**
 * @author vedad
 *
 */
public final class AudioDevPage extends MobileDemoModule {
	
	private VideoController audioCtlr;
	
	public AudioDevPage() {
		super("VideoDev");
	}
	
	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "controlContainer");
		
		audioCtlr = new VideoController(container);
		
		return container;
	}		
}
