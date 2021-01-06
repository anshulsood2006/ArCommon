package com.arsoft.projects.arenterprise.ardictionary.dao;

import java.util.List;

public interface IArDictionaryDao {

	public boolean add(String word, List<String> meaningList);

	public boolean edit(String word, List<String> meaningList);

	public boolean delete(String word);

	public List<String> search(String word);
}
