package com.arsoft.projects.arenterprise.ardictionary;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.arsoft.projects.arenterprise.ardictionary.contract.IArDictionary;

@RunWith(MockitoJUnitRunner.class)
public class ArDictionaryTest {
	
	@Mock
	IArDictionary arDictionary;
	
	@Test
	public void addTest(){
		List<String> meaningList = new ArrayList<>();
		meaningList.add("Sun");
		boolean added = arDictionary.add("Anshul", meaningList);
		assertEquals(added, false);
	}
	
	@Test
	public void findTest(){
		List<String> wordPresent = arDictionary.search("Anshul");
	}
}

