package de.jwic.samples.magnechos;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

public class EchoControllerWrapper implements IEchoController {

	private ScrollingListOfEchos scrollingList;
	
	public EchoControllerWrapper () { }
	
	public void init ( IControlContainer container, String name ) {
		scrollingList = new ScrollingListOfEchos( container );
		scrollingList.setName( name );
		scrollingList.deployContent();
	}
	
	public void reset() { scrollingList.reset(); }
	
	public void destroy() { scrollingList.destroy(); }
	
	public void setName( String user ) { scrollingList.setName(user); }
	
	public ControlContainer getControlContainer() { return scrollingList; }
	
}