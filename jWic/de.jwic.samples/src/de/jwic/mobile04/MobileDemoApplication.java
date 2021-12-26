package de.jwic.mobile04;

import java.util.ArrayList;
import java.util.List;

import de.jwic.base.Application;
import de.jwic.base.Control;
import de.jwic.base.IControlContainer;
import de.jwic.mobile04.demos.CheckBoxDemo;
import de.jwic.mobile04.demos.EchoTable;
import de.jwic.mobile04.demos.FlipSwitchDemo;
import de.jwic.mobile04.demos.InputDemo;
import de.jwic.mobile04.demos.SelectMenuDemo04;

/**
 * Created by boogie on 10/27/14.
 */
public class MobileDemoApplication extends Application {

	@Override
	public Control createRootControl(IControlContainer container) {
		
		final List<MobileDemoModule> mobileDemoModules = new ArrayList<MobileDemoModule>();

		mobileDemoModules.add(new CheckBoxDemo());
		mobileDemoModules.add(new EchoTable());
		mobileDemoModules.add(new FlipSwitchDemo());
		mobileDemoModules.add(new InputDemo());
		mobileDemoModules.add(new SelectMenuDemo04());
		
		return new MobileDemoPage(container, "demoPage", mobileDemoModules);
	}
}
