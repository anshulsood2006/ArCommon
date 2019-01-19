package com.arsoft.projects.arenterprise.ardictionary;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.arsoft.projects.arenterprise.ardictionary.contract.IArDictionary;

public class ArDictionary implements IArDictionary{
	
	public ArDictionary() {
		
	}

	@Override
	public boolean add(String word, String meaning) {
		boolean added = false;
		Map<String, List<String>> wordPresent = search(word);
		if(wordPresent == null){
			
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
	public Map<String, List<String>> search(String word) {
		if (StringUtils.isEmpty(word)){
			return null;
		}else{
			return null;
		}
	}
	
}
