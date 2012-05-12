/*
 * Created on Sep 30, 2011
 */
package com.apress.prospring3.ch6.crypto;

import java.util.Random;

/**
 * @author clarence
 */
public class KeyGenerator {

    public static final long WEAK_KEY = 0xFFFFFFF0000000L;
    public static final long STRONG_KEY = 0xACDF03F590AE56L;
    
    private Random rand = new Random();
    
    public long getKey() {
        int x = rand.nextInt(3);
        
        if(x == 1) {
            return WEAK_KEY;
        } else {
            return STRONG_KEY;
        }
    }
}
