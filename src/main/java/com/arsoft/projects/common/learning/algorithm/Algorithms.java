package com.arsoft.projects.common.learning.algorithm;

/**
 * 
 * 
 * @author anshul.sood
 *
 */
public class Algorithms {
	public static void main(String[] args) {
		String sentence = "Java is good language";
		System.out.println(sentence.length());
		sentence = StringUtil.reverseWordsInSentence(sentence);
		System.out.println(sentence.length());
	}
}
