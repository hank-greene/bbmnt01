package de.jwic.samples.magnechos;

import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

public interface IEchoController {
	public void init( IControlContainer container, String Name );
	public void reset();
	public void destroy();
	public void setName( String user ); // i.e. the listener profile
	public ControlContainer getControlContainer();
}