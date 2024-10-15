package com.kitter.question2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ChatBot {
	private static Map<String, String> questionAnswerPairs = new HashMap<>();

    static {
        questionAnswerPairs.put("What is your name?", "My name is Chatbot.");
        questionAnswerPairs.put("How can I help you?", "I can assist you with your queries.");
        questionAnswerPairs.put("What is the weather today?", "The weather is sunny.");
    }

    public static String findClosestMatch(String userQuestion) {
        String closestMatch = null;
        int maxMatchCount = 0;

        for (String question : questionAnswerPairs.keySet()) {
            int matchCount = getWordMatchCount(userQuestion.toLowerCase(), question.toLowerCase());

            if (matchCount > maxMatchCount) {
                maxMatchCount = matchCount;
                closestMatch = question;
            }
        }

        return closestMatch != null ? questionAnswerPairs.get(closestMatch) : "Sorry, I don't understand.";
    }

    private static int getWordMatchCount(String userQuestion, String predefinedQuestion) {
        Set<String> userWords = new HashSet<>(Arrays.asList(userQuestion.split(" ")));
        Set<String> predefinedWords = new HashSet<>(Arrays.asList(predefinedQuestion.split(" ")));

        userWords.retainAll(predefinedWords);
        return userWords.size();
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Ask me a question:");
        String userQuestion = scanner.nextLine();
        String answer = findClosestMatch(userQuestion);
        System.out.println(answer);

	}

}
