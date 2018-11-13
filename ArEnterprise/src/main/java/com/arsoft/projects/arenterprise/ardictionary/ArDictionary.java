package com.arsoft.projects.arenterprise.ardictionary;

import java.util.List;
import java.util.Map;

import com.arsoft.projects.arenterprise.ardictionary.contract.IArDictionary;

public class ArDictionary implements IArDictionary{
	
	public ArDictionary() {
		
	}

	@Override
	public boolean add(String word, String meaning) {
		boolean added = false;
		Map<String, List<String>> wordPresent = find(word);
		if(wordPresent != null){
			
		}
		return added;
	}
	
	@Override
	public boolean edit(String word, String meaning) {
		return false;
	}

	@Override
	public boolean delete(String word) {
		return false;
	}

	@Override
	public Map<String, List<String>> find(String word) {
		if (word == null || word.length() == 0){
			return null;
		}else{
			return null;
		}
	}
	
}
