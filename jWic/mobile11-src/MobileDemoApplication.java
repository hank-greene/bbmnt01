package de.jwic.mobile11;

import java.util.ArrayList;
import java.util.List;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.mobile11.demos.EchoWindow;
import de.jwic.mobile11.demos.InputDemo;
import de.jwic.mobile11.demos.SelectMenuDemo11;
import de.jwic.mobile11.demos.AudioDevPage;

public class MobileDemoApplication extends Application {

	@Override
	public Control createRootControl(IControlContainer container) {
		
		final List<MobileDemoModule> mobileDemoModules = new ArrayList<MobileDemoModule>();

		mobileDemoModules.add(new EchoWindow());
		mobileDemoModules.add(new AudioDevPage());
		mobileDemoModules.add(new SelectMenuDemo11());
		mobileDemoModules.add(new InputDemo());
		
		return new MobileDemoPage(container, "demoPage", mobileDemoModules);
	}
}
