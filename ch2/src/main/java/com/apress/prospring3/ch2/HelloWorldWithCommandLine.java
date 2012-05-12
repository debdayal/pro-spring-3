/**
 * Created on Sep 11, 2011
 */
package com.apress.prospring3.ch2;

/**
 * @author Clarence
 *
 */
public class HelloWorldWithCommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length > 0) {
			System.out.println(args[0]);
		} else {
			System.out.println("Hello World!");
		}

	}

}
