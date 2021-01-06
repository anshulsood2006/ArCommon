package com.arsoft.projects.arenterprise.ardictionary.contract;

import java.util.List;

public interface IArDictionary {
	public boolean add(String word, List<String> meaningList);

	public boolean edit(String word, List<String> meaningList);

	public boolean delete(String word);

	public List<String> search(String word);
}
