/*
 * Copyright (c) 2014 Meding Software Technik - All Rights Reserved.
 */
package com.uwemeding.bully;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringJoiner;

/**
 * Write (append) a tweet.
 * <p>
 * @author uwe
 */
public class TweetWriter extends PrintWriter {

	public TweetWriter(Writer writer) throws IOException {
		super(writer);
	}

	@Override
	public void close() {
		System.out.println("Closing tweets");
		super.close();
	}

	/**
	 * Print the tweet.
	 * <p>
	 * @param tweet
	 */
	public void println(Tweet tweet) {
		StringJoiner joiner = new StringJoiner("\t");
		joiner.add(tweet.getName())
				.add(tweet.getBlurb())
				.add(tweet.isBully() ? "bullying" : "not_bullying");
		super.println(joiner.toString());
	}
}
