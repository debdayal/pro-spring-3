/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public class FtpArtworkSender implements ArtworkSender {

    public void sendArtwork(String artworkPath, Recipient recipient) {
        // ftp logic here...
    }

    public String getFriendlyName() {
        return "File Transfer Protocol";
    }

    public String getShortName() {
        return "ftp";
    }	
	
}
