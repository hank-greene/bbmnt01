package de.jwic.mobile12;

import java.util.ArrayList;
import java.util.List;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.mobile12.demos.FrontPage2;
import de.jwic.mobile12.demos.InputDemo;
import de.jwic.mobile12.demos.SelectMenuDemo12;
import de.jwic.mobile12.demos.AudioDevPage;
import de.jwic.mobile12.demos.MobileAudioRND;

public class MobileDemoApplication extends Application {

	//BBMNTProperties bbmntProps = BBMNTProperties.getInstance();

	@Override
	public Control createRootControl(IControlContainer container) {
		
		final List<MobileDemoModule> mobileDemoModules = new ArrayList<MobileDemoModule>();

		mobileDemoModules.add(new FrontPage2());
		mobileDemoModules.add(new MobileAudioRND());
		mobileDemoModules.add(new AudioDevPage());
		mobileDemoModules.add(new SelectMenuDemo12());
		mobileDemoModules.add(new InputDemo());
		
		return new MobileDemoPage(container, "demoPage", mobileDemoModules);
	}
}
