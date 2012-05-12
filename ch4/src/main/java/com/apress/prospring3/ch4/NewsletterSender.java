/**
 * Created on Sep 20, 2011
 */
package com.apress.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public interface NewsletterSender {

    public void setSmtpServer(String smtpServer);
    public String getSmtpServer();
    
    public void setFromAddress(String fromAddress);
    public String getFromAddress();
    
    public void send();
	
}
