package com.arsoft.projects.arenterprise.ardictionary.contract;

import java.util.List;
import java.util.Map;

public interface IArDictionary {
	public boolean add(String word, String meaning);
	public boolean edit(String word, String meaning);
	public boolean delete(String word);
	public Map<String, List<String>> search(String word);
}
