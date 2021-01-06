package com.arsoft.projects.arenterprise.ardictionary;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.arsoft.projects.arenterprise.ardictionary.contract.IArDictionary;

public class ArDictionary implements IArDictionary{
	
	public ArDictionary() {
		
	}

	@Override
	public boolean add(String word, List<String> meaningList) {
		boolean added = false;
		List<String> wordPresent = search(word);
		if (wordPresent == null || wordPresent.isEmpty()) {
			
		}
		return added;
	}
	
	@Override
	public boolean edit(String word, List<String> meaningList) {
		return false;
	}

	@Override
	public boolean delete(String word) {
		return false;
	}

	@Override
	public List<String> search(String word) {
		if (StringUtils.isEmpty(word)){
			return null;
		}else{
			return null;
		}
	}
	
}
