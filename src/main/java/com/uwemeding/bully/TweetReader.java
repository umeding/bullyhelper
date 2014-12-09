/*
 * Copyright (c) 2014 Meding Software Technik - All Rights Reserved.
 */
package com.uwemeding.bully;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

/**
 * Read a tweet.
 * <p>
 * @author uwe
 */
public class TweetReader extends LineNumberReader {

	public TweetReader(Reader in) {
		super(in);
	}

	public TweetReader(Reader in, int sz) {
		super(in, sz);
	}

	/**
	 * Fast forward to a particular line.
	 * <p>
	 * @param lineno
	 * @throws java.io.IOException
	 */
	public void fastForward(int lineno) throws IOException {
		for (int i = 0; i < lineno - 1; i++) {
			readLine();
		}
	}

	/**
	 * Read the next tweet from the tweet file.
	 * <p>
	 * @return the next tweet
	 * @throws IOException
	 */
	public Tweet nextTweet() throws IOException {
		while (true) {
			String line = readLine();
			if (line.startsWith("@")) {
				String[] parts = line.split("\t");
				if (parts.length == 3) {
					return new Tweet(parts[0], parts[1]);
				}
			}
		}
	}
}
