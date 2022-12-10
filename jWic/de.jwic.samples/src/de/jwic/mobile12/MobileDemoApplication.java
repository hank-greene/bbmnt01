package de.jwic.mobile12;

import java.util.ArrayList;
import java.util.List;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.mobile12.demos.EchoWindow;
import de.jwic.mobile12.demos.InputDemo;
import de.jwic.mobile12.demos.SelectMenuDemo12;
import de.jwic.mobile12.demos.AudioDevPage;
import de.jwic.mobile12.demos.MobileAudioRND;

public class MobileDemoApplication extends Application {

	@Override
	public Control createRootControl(IControlContainer container) {
		
		final List<MobileDemoModule> mobileDemoModules = new ArrayList<MobileDemoModule>();

		System.out.println("::MobileAudioRND()");
		mobileDemoModules.add(new MobileAudioRND());
		System.out.println("::EchoWindow()");
		mobileDemoModules.add(new EchoWindow());
		System.out.println("::AudioDevPage()");
		mobileDemoModules.add(new AudioDevPage());
		System.out.println("::SelectMenuDemo12()");
		mobileDemoModules.add(new SelectMenuDemo12());
		System.out.println("::InputDemo()");
		mobileDemoModules.add(new InputDemo());
		
		return new MobileDemoPage(container, "demoPage", mobileDemoModules);
	}
}
