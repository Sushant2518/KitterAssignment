package com.kitter.question1;

import java.util.Scanner;

public class NormalizeString {
	public static String normalizeString(String str) {
        str = str.trim();

        str = str.replaceAll("[^a-zA-Z0-9\\s]", "");

        str = str.replaceAll("\\s+", " ");

        String[] words = str.split(" ");
        StringBuilder normalizedString = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                normalizedString.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1).toLowerCase())
                                .append(" ");
            }
        }

        return normalizedString.toString().trim();
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Enter the input string:");
        String input = scanner.nextLine();
        String normalized = normalizeString(input);
        System.out.println("Normalized String: " + normalized);

	}

}
