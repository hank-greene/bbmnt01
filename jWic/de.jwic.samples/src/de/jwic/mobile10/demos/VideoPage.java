package de.jwic.mobile10.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.mobile10.MobileDemoModule;

import de.jwic.mobile10.demos.audio.VideoController;

/**
 * @author vedad
 *
 */
public final class VideoPage extends MobileDemoModule {
	
	private VideoController videoCtlr;
	
	public VideoPage() {
		super("VideoDev");
	}
	
	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = 
		             new ControlContainer(controlContainer, "controlContainer");
		
		videoCtlr = new VideoController(container);
		
		return container;
	}		
}
