package com.arsoft.projects.arenterprise.ardictionary.dao;

import java.util.List;
import java.util.Map;

public class ArDictionaryDao implements IArDictionaryDao {

	@Override
	public boolean add(String word, String meaning) {
		return false;
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
		return null;
	}

}
