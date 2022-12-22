package de.jwic.mobile09;

import java.util.ArrayList;
import java.util.List;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.mobile09.demos.EchoWindow;
import de.jwic.mobile09.demos.InputDemo;
import de.jwic.mobile09.demos.SelectMenuDemo09;

public class MobileDemoApplication extends Application {

	@Override
	public Control createRootControl(IControlContainer container) {
		
		final List<MobileDemoModule> mobileDemoModules = new ArrayList<MobileDemoModule>();

		mobileDemoModules.add(new EchoWindow());
		mobileDemoModules.add(new SelectMenuDemo09());
		mobileDemoModules.add(new InputDemo());
		
		return new MobileDemoPage(container, "demoPage", mobileDemoModules);
	}
}
