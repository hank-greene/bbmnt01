/*
 * de.jwic.controls.AudioButton
 * $Id: Button.java,v 1.3 2011/09/09 15:09:01 adrianionescu12 Exp $
 */
package de.jwic.mobile07.demos;

import de.jwic.base.IControlContainer;
import de.jwic.base.ImageRef;
import de.jwic.base.IncludeJsOption;
import de.jwic.base.JavaScriptSupport;
import de.jwic.controls.menu.Menu;
import de.jwic.controls.SelectableControl;

//whew thi is messy
import de.jwic.controls.mobile04.Icon;
import de.jwic.controls.mobile04.IconPos;
import de.jwic.controls.mobile04.Theme;


/**
 * Represents the &lt;button&gt; html element. 
 * This button displays links to an audio, and - future - video file.
 * 
 * The button is using the jQuery UI button element for representation by default. 
 * It is however possible, to switch back to the old jWic 4.x design by setting 
 * the templateName to "de.jwic.controls.ButtonLegacy".
 *  
 * @author Hank Greene
 * @version $Revision: 0.1 $
 */
@JavaScriptSupport
public class AudioButton extends SelectableControl {

	private static final long serialVersionUID = 1L;

	private String title = null;
	private ImageRef iconEnabled = null;
	private ImageRef iconDisabled = null;
	private String tooltip = null;
	private String confirmMsg = "";
	private String audiolink = "not set";
	
	private Menu menu = null;

	private boolean corners = true;
	private boolean inline = false;
	private boolean mini = false;
	private boolean shadow = true;
	private Icon iconClass = null;
	private IconPos iconpos = IconPos.LEFT;
	private Theme theme = null;
	private String wrapperClass = null;
	
	/**
	 * @param container
	 */
	public AudioButton(IControlContainer container) {
		super(container);
		init();
		System.out.println("AudioButton(IControlContainer container)");
	}
	
	/**
	 * @param container
	 * @param name
	 */
	public AudioButton(IControlContainer container, String name) {
		super(container, name);
		init();
		System.out.println("AudioButton(IControlContainer container, String name)");
	}
	
	/* (non-Javadoc)
	 * @see de.jwic.base.Control#init()
	 */
	private void init() {
		setCssClass("j-button");
		if (title == null) {
			title = getName();
		}
	}
	
	/* (non-Javadoc)
	 * @see de.jwic.base.Control#actionPerformed(java.lang.String, java.lang.String)
	 */
	public void actionPerformed(String actionId, String parameter) {
		System.out.println("++++++++++++++++++++AudioButton.actionPerformed");
		System.out.println("             "+actionId+"  "+parameter);
		click();
	}
	
	/**
	 * @return Returns the title.
	 */
	@IncludeJsOption
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
		setRequireRedraw(true);
	}
	
	/**
	 * @return true if the button has non-empty title, false otherwise
	 */
	@IncludeJsOption
	public boolean hasTitle(){
		return title!=null && !title.isEmpty();
	}
	
	
	//private String audioLink = "not set";
	public void setAudioLink(String l) {
		audiolink = l;
	}
	
	public String getAudioLink() {
		return audiolink;
	}
	
	
	/**
	 * Returns the icon for the button depending on the state.
	 * @return
	 */
	public ImageRef getIcon() {
		if (!isEnabled()) {
			return iconDisabled != null ? iconDisabled : iconEnabled;
		} else {
			return iconEnabled;
		}
	}
	
	/**
	 * @return
	 */
	@IncludeJsOption
	public String getIconPath(){
		ImageRef icon = this.getIcon();
		return icon != null ? icon.getPath() : "";
	}

	/**
	 * Returns true if an icon is specified.
	 * @return
	 */
	@IncludeJsOption
	public boolean hasIcon(){
		return iconEnabled != null; 
	}

	/**
	 * @return Returns the tooltip.
	 */
	@IncludeJsOption
	public String getTooltip() {
		return tooltip;
	}
	/**
	 * @param tooltip The tooltip to set.
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
		requireRedraw();
	}
	/**
	 * @return Returns the confirmMsg.
	 */
	@IncludeJsOption
	public String getConfirmMsg() {
		return confirmMsg;
	}
	/**
	 * @param confirmMsg The confirmMsg to set.
	 */
	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
		requireRedraw();
	}
	/**
	 * @return the iconDisabled
	 */
	public ImageRef getIconDisabled() {
		return iconDisabled;
	}
	
	/**
	 * @return
	 */
	@IncludeJsOption
	public String getIconDisabledPath(){
		return this.iconDisabled != null ? this.iconDisabled.getPath() : "";
	}
	
	/**
	 * @param iconDisabled the iconDisabled to set
	 */
	public void setIconDisabled(ImageRef iconDisabled) {
		this.iconDisabled = iconDisabled;
		requireRedraw();
	}
	
	/**
	 * @return the iconEnabled
	 */
	public ImageRef getIconEnabled() {
		return iconEnabled;
	}
	
	/**
	 * @return
	 */
	@IncludeJsOption
	public String getIconEnabledPath() {
		return iconEnabled != null ? iconEnabled.getPath() : "";
	}
	
	/**
	 * @param iconEnabled the iconEnabled to set
	 */
	public void setIconEnabled(ImageRef iconEnabled) {
		this.iconEnabled = iconEnabled;
		requireRedraw();
	}
	
	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}
	
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	/**
	 * @return
	 */
	@IncludeJsOption
	public String getMenuId(){
		return menu != null ? menu.getControlID(): null;
	}
}