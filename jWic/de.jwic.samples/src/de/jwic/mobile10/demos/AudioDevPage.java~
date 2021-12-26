package de.jwic.mobile10.demos;

import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;
import de.jwic.data.ISelectElement;
import de.jwic.mobile10.MobileDemoModule;

import de.jwic.mobile10.demos.audio.AudioController;

/**
 * @author vedad
 *
 */
public final class AudioDevPage extends MobileDemoModule {
	
	private AudioController audioCtlr;
	
	public AudioDevPage() {
		super("AudioDev");
	}
	
	/* (non-Javadoc)
	 * @see de.jwic.mobile.MobileDemoModule#createPage(de.jwic.base.IControlContainer)
	 */
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "controlContainer");
		
		audioCtlr = new AudioController(container);
		
		return container;
	}		
}
