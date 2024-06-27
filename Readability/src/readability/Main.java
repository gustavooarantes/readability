package readability;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// Initialize the scanner and prompts user for text
		Scanner scanner = new Scanner(System.in);
		System.out.println("Text:");
		String text = scanner.nextLine();
		
		int letters = countLetters(text);
		int words = countWords(text);
		int sentences = countSentences(text);
		
		float l = (float) (letters / words) * 100;
		float s = (float) (sentences / words) * 100;
		int index = (int) (0.0588 * l - 0.296 * s - 15.8);
		
		if (index < 1) {
			System.out.println("Before Grade 1");
		} else if (index > 16) {
			System.out.println("Grade 16+");
		} else {
			System.out.print("Grade ");
			System.out.println(index);
		}
		
	}
	
	public static int countLetters(String text) {
		char textArray[] = text.toCharArray();
		int letters = 0;
		
		for (int i = 0; i < textArray.length; i++) {
			if (Character.isLetter(textArray[i])) {
				letters += 1;
			} else {
				letters = letters;
			}	
		}
		
		return letters;
	}
	
	public static int countWords(String text) {
		int words = text.split("\\s").length;
	
		return words;
	}
	
	public static int countSentences(String text) {
		char textArray[] = text.toCharArray();
		int sentences = 1;
		
		for (int i = 0; i < textArray.length; i++) {
			if (textArray[i] == '.' || textArray[i] == '!' || textArray[i] == '?') {
				sentences += 1;
			} else {
				sentences = sentences;
			}
		}
		
		return sentences;
	}
	
}
