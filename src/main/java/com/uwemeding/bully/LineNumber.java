/*
 * Copyright (c) 2014 Meding Software Technik - All Rights Reserved.
 */
package com.uwemeding.bully;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 * Read and update the current line number file.
 * <p>
 * @author uwe
 */
public class LineNumber {

	private final static File LINENO_FILE = new File("lineno.txt");

	public LineNumber() {
	}

	/**
	 * Get the next line number.
	 * <p>
	 * @return the next line number
	 * @throws java.io.IOException
	 */
	public int nextLine() throws IOException {
		int lineNumber = 0;
		// read the current line number
		if (LINENO_FILE.exists()) {
			try (FileReader fr = new FileReader(LINENO_FILE);
					LineNumberReader fp = new LineNumberReader(fr)) {
				String line = fp.readLine();
				lineNumber = Integer.parseInt(line);
			} catch (NumberFormatException nfe) {
				lineNumber = 0;
			}
		}

		lineNumber++;

		// save the new line number
		updateLine(lineNumber);
		return lineNumber;
	}

	/**
	 * Update the line number position.
	 * <p>
	 * @param lineNumber
	 * @throws IOException
	 */
	public void updateLine(int lineNumber) throws IOException {
		try (FileWriter fw = new FileWriter(LINENO_FILE);
				PrintWriter pw = new PrintWriter(fw)) {
			pw.println(lineNumber);
		}
	}

}
