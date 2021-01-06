package com.arsoft.projects.arenterprise.ardictionary.dao;

import java.util.List;

public class ArDictionaryDao implements IArDictionaryDao {

	@Override
	public boolean add(String word, List<String> meaningList) {
		return false;
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
		return null;
	}

}
