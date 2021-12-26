package de.jwic.magneticechos01.demos;

import de.jwic.controls.actions.IAction;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.jwic.base.ImageRef;
	
public class IndexAction implements IAction2 {
    
    protected transient Log log = LogFactory.getLog(getClass());
    
    private String key;
    private String name;
    private String echo = "not set";
    private boolean active = false;
    
    public IndexAction(int x, String e) {
    	key = Integer.toString(x);
        name = Integer.toString(x);
        echo = e;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }
    
    public void removePropertyChangeListener(PropertyChangeListener lisetener) {
    }
    
    public String getTitle() {
        return name;
    }
    
    public String getImagePath() {
        return "";
    }
    
    public boolean isEnabled() {
        return true;
    }
    
    public boolean isVisible() {
        return true;
    }
    
    public void setActiveFalse(){
        log.debug("setActiveFalse");
        active = false;
    }
    
    public void setActiveTrue(){
        log.debug("setActiveTrue");
        active = true;
    }
    
    public boolean isActive() {
        log.debug("isActive "+active);
        return active;
    }
    
    public void run() {
        log.debug("  present guest " + name);
    }
   	public String getTooltip(){
   		return "";
   	}
	public void setTooltip(String tooltip){
	}
	public void setVisible(boolean visible){
	}
	public void setEnabled(boolean enabled){
	}
	public void setIconDisabled(ImageRef iconDisabled){
	}
	public ImageRef getIconDisabled(){
		return null;
	}
	public void setIconEnabled(ImageRef iconEnabled){
	}
	public ImageRef getIconEnabled(){
		return null;
	}
	public void setTitle(String title){
	}
	
	public void setEcho(String e){
		echo = e;
	}

	public String getEcho(){
		return echo;
	}
	
	
}

