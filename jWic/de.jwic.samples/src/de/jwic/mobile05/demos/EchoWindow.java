package de.jwic.mobile05.demos;

import de.jwic.mobile05.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.controls.ScrollableContainer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EchoWindow extends MobileDemoModule {
	
    protected transient Log log = LogFactory.getLog(getClass());
    
	private EchoLabel label;
    
	public EchoWindow() {
		super("Echo Window");
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer);
		
		label = new EchoLabel(container, "label");
		label.setText("Magnetic Echo");
		
		System.out.println("=====> class name "+getClass().getName()+"  <======================================");
		ScrollableContainer sc = new ScrollableContainer(container);
		sc.setHeight("250px");
		sc.setWidth("250px");
		
		EchoWindowList ewList = new EchoWindowList( sc, label );
		
		return container;
	}

}