package com.arsoft.projects.common.learning.algorithm;

/**
 * Reverse the words in a String
 * 
 * @author anshul.sood
 *
 */
public class StringUtil {

	public static String reverseWordsInSentence(String sentence){
		String[] splits = sentence.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = splits.length - 1 ; i >= 0; i--){
			sb.append(splits[i]);
			if(i != 0){
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
