/**
 * 
 */
package org.sirius.client.win32.classes.controls;

import org.sirius.client.win32.classes.Window;
import org.sirius.client.win32.types.Win32Locator;

/**
 * @author Myk Kolisnyk
 * 
 */
public class PageList extends List {

	/**
	 * @param client
	 * @param locator
	 */
	public PageList(Window parent, Win32Locator locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}

	public String[] getTabNames(){
		return null;
	}
	
	public int getTabsCount(){
		return 0;
	}
	
	public void select(String tabName){
		;
	}

	public void select(int index){
		;
	}
	
	public int getSelectedTab(){
		return 0;
	}
	
	public String getSelectedTabName(){
		return "";
	}
}
