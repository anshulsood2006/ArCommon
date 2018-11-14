package com.arsoft.projects.arenterprise.ardictionary.contract;

import java.util.List;
import java.util.Map;

public interface IArDictionary {
	default String hello() {
		return "Hello from IArDictionary default method";
	}
	public boolean add(String word, String meaning);
	public boolean edit(String word, String meaning);
	public boolean delete(String word);
	public Map<String, List<String>> find(String word);
	static String hi() {
		return "Hi from IArDictionary static method";
	}
}
