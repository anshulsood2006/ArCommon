package com.arsoft.projects.arenterprise.ardictionary.dao;

import java.util.List;
import java.util.Map;

public interface IArDictionaryDao {
	public boolean add(String word, String meaning);
	public boolean edit(String word, String meaning);
	public boolean delete(String word);
	public Map<String, List<String>> search(String word);
}
