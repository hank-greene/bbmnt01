package de.jwic.controls.mobile08;

import de.jwic.base.IControlContainer;
import de.jwic.base.IncludeJsOption;
import de.jwic.base.JavaScriptSupport;
import de.jwic.controls.CheckBox;

import de.jwic.controls.mobile03.IconPos;

@JavaScriptSupport
public class MTransitionBox extends CheckBox {

	private static final long serialVersionUID = 1L;

	private boolean mini = false;
	private IconPos iconpos = IconPos.LEFT;
	private String wrapperClass = null;

	/**
	 * Constructs a new control instance and adds it to the specified container with the specified name. If the name is <code>null</code>, a
	 * unique name will be choosen by the container.
	 *
	 * @param container container of the check box
	 * @param name name of the check box
	 */
	public MTransitionBox(IControlContainer container, String name) {
		super(container, name);
		System.out.println("constructor MTransitionBox");
	}

	/**
	 * If set to true, this will display a more compact version of the checkboxradio that uses less vertical height by applying the ui-mini class to the outermost element of the checkboxradio widget.
	 */
	@IncludeJsOption
	public boolean isMini() {
		System.out.println("MTransitionBox.isMini()");
		return mini;
	}

	/**
	 * If set to true, this will display a more compact version of the checkboxradio that uses less vertical height by applying the ui-mini class to the outermost element of the checkboxradio widget.
	 */
	public void setMini(boolean mini) {
		System.out.println("MTransitionBox.setMini");
		if (mini != this.mini)
			requireRedraw();
		this.mini = mini;
	}

	/**
	 * Allows you to specify on which side of the checkbox or radio button the checkmark/radio icon will appear.
	 */
	@IncludeJsOption
	public IconPos getIconpos() {
		System.out.println("MTransitionBox.getIconpos()");
		return iconpos;
	}

	/**
	 * Allows you to specify on which side of the checkbox or radio button the checkmark/radio icon will appear.
	 */
	public void setIconpos(IconPos iconpos) {
		System.out.println("MTransitionBox.setIconpos");
		if (!iconpos.equals(this.iconpos))
			requireRedraw();
		this.iconpos = iconpos;
	}

	/**
	 * This option allows you to specify one or more space-separated class names to be added to the wrapper div element by the framework.
	 */
	@IncludeJsOption
	public String getWrapperClass() {
		System.out.println("MTransitionBox.getWrapperClass");
		return wrapperClass;
	}

	/**
	 * This option allows you to specify one or more space-separated class names to be added to the wrapper div element by the framework.
	 */
	public void setWrapperClass(String wrapperClass) {
		System.out.println("MTransitionBox.setWrapperClass");
		if (!wrapperClass.equals(this.wrapperClass))
			requireRedraw();
		this.wrapperClass = wrapperClass;
	}
}
