package com.arsoft.projects.common.annotation;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public boolean logic(String string, boolean isBalanced) {
		if (string.length() == 0){
			return isBalanced;
		}
		Map<String, String> bracetMap = new HashMap<String, String>();
		bracetMap.put("[", "]");
		bracetMap.put("{", "}");
		bracetMap.put("(", ")");
		bracetMap.put("<", ">");
		bracetMap.put("<", ">");
		int lastIndexStart = -1;
		String startBracket = null;
		for (int i = 0 ; i < string.length(); i++){
			String character = Character.toString(string.charAt(i));
			if (bracetMap.containsKey(character)){
				lastIndexStart = i;
				startBracket = character;
			}
		}
		//System.out.println("Last Index Start Bracket: "+ lastIndexStart);
		//System.out.println("Start Bracket : "+ startBracket);
		String firstString = string.substring(0, lastIndexStart);
		//System.out.println("First String: "+firstString);
		String substring = string.substring(lastIndexStart + 1, string.length());
		//System.out.println("Substring : "+ substring);
		String closeBracket = bracetMap.get(startBracket);
		//System.out.println("Close Bracket"+closeBracket);
		int indexCloseBracket = -1;
		for (int j = 0; j < substring.length() ; j ++){
			String character = Character.toString(substring.charAt(j));
			if (closeBracket.equals(character)){
				indexCloseBracket = j;
				break;
			}
		}
		if(indexCloseBracket == -1){
			isBalanced = false;
			return isBalanced;
		}
		//System.out.println("First Index Close Bracket: "+ indexCloseBracket);
		String substringTwo = substring.substring(0, indexCloseBracket + 1);
		//System.out.println("Substring Two: "+ substringTwo);
		
		Map<String, String> bracetMapCopy = bracetMap;
		bracetMapCopy.remove(startBracket);
		int beginIndex = substring.indexOf(closeBracket);
		for (String key: bracetMapCopy.keySet()){
			String value = bracetMapCopy.get(key);
			for (int i = 0; i < substringTwo.length(); i++){
				String character = Character.toString(substring.charAt(i));	
				if(character.equals(value)){
					isBalanced = false;
					break;
				}
			}
			if (!isBalanced){
				break;
			}
		}
		if (!isBalanced){
			return isBalanced;
		}
		String lastString = substring.substring(beginIndex + 1, substring.length());
		//System.out.println("Last String: "+ lastString);
		String newString = firstString+lastString;
		System.out.println("New String: "+newString);
		return logic(newString, isBalanced);
	}
	
	public static void main(String args[]) {
		Test test = new Test();
		String string = "[{anshul (asood)  [is]  {attending} [a {<>} n]} interview]";
		boolean isBalanced = test.logic(string, true);
		System.out.println(isBalanced);
	}

	
}
