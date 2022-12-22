/*******************************************************************************
 *  
 *******************************************************************************/
package de.jwic.mobile06.demos;

import de.jwic.controls.actions.IAction;

/**
 * Represents the backend side of a command which may be triggered by the end user. Actions
 * are typically added to navigators or menues. The UI is handled by an container that uses
 * the actions properties. When the user triggers the command via the container, actions 
 * rund method is invoked.
 * 
 * @author Florian Lippisch
 * @version $Revision: 1.6 $
 */
public interface IAction2 extends IAction {
	
	public void setEcho(String e);

	public String getEcho();
	
}
