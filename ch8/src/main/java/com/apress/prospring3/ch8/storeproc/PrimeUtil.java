/**
 * Created on Oct 9, 2011
 */
package com.apress.prospring3.ch8.storeproc;

import java.math.BigInteger;

/**
 * @author Clarence
 *
 */
public class PrimeUtil {

	public static int nextPrime(int value) {
	    return new BigInteger(new Integer(value).toString()).nextProbablePrime().intValue();
	}
	
}
