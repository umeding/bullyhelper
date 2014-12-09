/*
 * Copyright (c) 2014 Meding Software Technik - All Rights Reserved.
 */
package com.uwemeding.bully;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * A tweet.
 * <p>
 * @author uwe
 */
public class Tweet {

	private final static int CUTOFF = 50;

	private final String name;
	private final String blurb;
	private boolean bully;

	public Tweet(String name, String blurb) {
		this.name = name;
		this.blurb = blurb;
		this.bully = false;
	}

	public boolean isBully() {
		return bully;
	}

	public void setBully(boolean bully) {
		this.bully = bully;
	}

	public String getName() {
		return name;
	}

	public String getBlurb() {
		return blurb;
	}

	/**
	 * (Simple) pretty print the blurb.
	 * <p>
	 * @return text buffer
	 */
	public String prettyPrint() {

		StringWriter sw = new StringWriter();
		PrintWriter fp = new PrintWriter(sw);

		int charCount = 0;
		for (Character c : blurb.toCharArray()) {

			charCount++;
			if (charCount > CUTOFF && Character.isWhitespace(c)) {
				charCount = 0;
				fp.println();
			} else {
				fp.print(c);
			}
		}
		if (charCount > 0) {
			fp.println();
		}

		return sw.toString();
	}

	@Override
	public String toString() {
		return "Tweet{" + "name=" + name + ", blurb=" + blurb + ", bully=" + bully + '}';
	}

}
