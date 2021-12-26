package de.jwic.samples.magnechos;

import de.jwic.samples.magnechos.IEchoController;

public class Echo_Control_Factory {
	
	public Echo_Control_Factory() {
	}
	
	public IEchoController getEchoController( String className ) {
		IEchoController controller = null;
		try {
			//System.out.println("-----> Echo Control Factory ");
			Class classObject = Class.forName( className );
			Object objectInstance = classObject.newInstance();
			controller = (IEchoController)objectInstance;
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
		return controller;
	}
	
}