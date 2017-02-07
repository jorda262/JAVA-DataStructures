package edu.century.pa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleParser {

	/*
	 * Load Data method. Receives a file from main and takes in a line at a time
	 * storing each left parenthesis in a stack data structure and ignores all
	 * other characters besides the right parenthesis. Once it finds a right one
	 * it compares it to the left one on the top of the stack. If it finds a
	 * mismatch it prints out the code and what line the error occurs. If the
	 * method finds no errors it prints the file and prints 'No Errors'.
	 */
	public static void loadData(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file));
		Stack letter = new Stack();
		boolean end = true;
		int count = 1;
		while (scan.hasNext()) {
			String sentence = scan.nextLine();
			char[] array = sentence.toCharArray();
			for (int i = 0; i < array.length; i++) {
				// If statement for locating left parenthesis
				if (array[i] == '{' || array[i] == '[' || array[i] == '(' || array[i] == '<') {
					char character = array[i];
					int line = count;
					Token parser = new Token(character, line);
					letter.push(parser);
				}
				// Else if statement for locating right parenthesis
				else if (array[i] == '}' || array[i] == ']' || array[i] == ')' || array[i] == '>') {
					char character = array[i];
					int line = count;
					Token parser = letter.pop();
					char got = parser.getCharacter();
					// If statement for comparing curly parenthesis
					if (got == '{' && array[i] != '}') {
						Scanner missed = new Scanner(new File(file));
						while (missed.hasNext()) {
							String sentences = missed.nextLine();
							System.out.println(sentences);
						}
						missed.close();
						end = false;
						System.out.println("\nFile" + file + " is unbalanced: expecting a }, but found a " + array[i]
								+ " in line " + line);

					}
					// Else if statement for comparing regular parenthesis
					else if (got == '(' && character != ')') {
						Scanner missed = new Scanner(new File(file));
						while (missed.hasNext()) {
							String sentences = missed.nextLine();
							System.out.println(sentences);
						}
						missed.close();
						end = false;
						System.out.println("\nFile " + file + " is unbalanced: expecting a ), but found a " + array[i]
								+ " in line " + line);

					}
					// Else if statement for comparing angled brackets
					else if (got == '<' && character != '>') {
						Scanner missed = new Scanner(new File(file));
						while (missed.hasNext()) {
							String sentences = missed.nextLine();
							System.out.println(sentences);
						}
						missed.close();
						end = false;
						System.out.println("\nFile " + file + " is unbalanced: expecting a >, but found a " + array[i]
								+ " in line " + line);

					}
					// Else if statement for comparing square brackets
					else if (got == '[' && character != ']') {
						Scanner missed = new Scanner(new File(file));
						while (missed.hasNext()) {
							String sentences = missed.nextLine();
							System.out.println(sentences);
						}
						missed.close();
						end = false;
						System.out.println("\nFile " + file + " is unbalanced: expecting a ], but found a " + array[i]
								+ " in line " + line);
					}
				}
			}
			count++;
		}
		// If statement for printing out balanced files
		if (end == true) {
			Scanner balanced = new Scanner(new File(file));
			while (balanced.hasNext()) {
				String sentences = balanced.nextLine();
				System.out.println(sentences);
			}
			balanced.close();
			System.out.println("\nFile " + file + " is balanced.");

		}
		System.out.print("\n");
		scan.close();

	}

	public static void main(String[] args) {
		try {
			loadData("example1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			loadData("example2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			loadData("example3.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			loadData("example4.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
