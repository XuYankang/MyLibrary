package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class WriteToFile {
	/**
	 * write string to a new file : d:/out.txt if the file is not exists, create
	 * a new txt format file, else rewrite the existed file
	 * 
	 * @param text
	 * @return
	 */
	public static boolean writeStringTofile(String text) {
		return writeStringToFile(text, new File("d:/out.txt"));
	}

	/**
	 * write string to a giving file
	 * 
	 * @param text
	 * @param out
	 * @return
	 */
	public static boolean writeStringToFile(String text, File out) {
		FileWriter fwriter;
		try {
			fwriter = new FileWriter(out);
			fwriter.write(text);
			fwriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * append a string to a existed file
	 * 
	 * @param text
	 * @param append
	 */
	public static void appendStringToFile(String text, File append) {
		FileWriter fwriter;
		try {
			fwriter = new FileWriter(append,true);
			fwriter.append(text);
			fwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		appendStringToFile("hello\n", new File("d:/out.txt"));
	}
}
