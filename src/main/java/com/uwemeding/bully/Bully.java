/*
 * Copyright (c) 2014 Meding Software Technik - All Rights Reserved.
 */
package com.uwemeding.bully;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.Writer;

/**
 * Read the tweets and mark them with a bullying flag
 * <p>
 * @author uwe
 */
public class Bully {

	private static final File RAWTWEETS_FILE = new File("rawTweets.txt");
	private static final File COOKEDTWEETS_FILE = new File("cookedTweets.txt");

	private Bully() {

	}

	private void execute() throws Exception {

		try (TweetReader tr = new TweetReader(new FileReader(RAWTWEETS_FILE));
				TweetWriter tw = new TweetWriter(new FileWriter(COOKEDTWEETS_FILE, true))) {

			LineNumber lineNumber = new LineNumber();
			int nextLine = lineNumber.nextLine();
			tr.fastForward(nextLine);

			LineNumberReader in = new LineNumberReader(new InputStreamReader(System.in));

			// run until we get bored or we hit an exception
			while (true) {

				Tweet tweet = tr.nextTweet();

				System.out.println("-------- " + tweet.getName());
				System.out.println(tweet.prettyPrint());
				System.out.print("> ");

				String console = in.readLine();
				if (console == null) {
					tw.close();
					System.exit(0);
				}

				tweet.setBully(console.toLowerCase().startsWith("y"));
				tw.println(tweet);
			}
		} 

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception {
		new Bully().execute();
	}

}
