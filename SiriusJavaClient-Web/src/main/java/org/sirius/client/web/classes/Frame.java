/**
 * 
 */
package org.sirius.client.web.classes;

import java.rmi.RemoteException;

import org.sirius.client.web.WebClient;
import org.sirius.client.web.core.Dimension;
import org.sirius.client.web.core.Point;

/**
 * @author Myk Kolisnyk
 * 
 */
public class Frame {

    protected WebClient client  = null;
    protected String    locator = "";

    /**
	 * 
	 */
    public Frame(final WebClient client, final String locator) {
        this.client = client;
        this.locator = locator;
    }

    public boolean exists() {
        return false;
    }

    public Point getLocation() throws RemoteException {
        return this.client.core().getLocation(null, locator);
    }

    public String getLocator() {
        return this.locator;
    }

    public Dimension getSize() throws RemoteException {
        return this.client.core().getSize(null, locator);
    }

    public String getURL() throws RemoteException {
        return this.client.core().getURL();
    }

    public String innerHtml() throws RemoteException {
        return this.client.core().getAttribute(null, locator, "innerHTML");
    }

    public void switchTo(final Frame frame) throws RemoteException {
        this.client.core().selectFrameByName(frame.getLocator());
    }
}
